package com.idorasi.profilematcher.service;

import static com.idorasi.profilematcher.converter.PlayerDtoConverter.convertFromEntity;

import com.idorasi.profilematcher.client.CampaignsClient;
import com.idorasi.profilematcher.converter.PlayerDtoConverter;
import com.idorasi.profilematcher.dto.CampaignsDto;
import com.idorasi.profilematcher.dto.PlayerCreateDto;
import com.idorasi.profilematcher.dto.PlayerDto;
import com.idorasi.profilematcher.model.Device;
import com.idorasi.profilematcher.model.Inventory;
import com.idorasi.profilematcher.model.Player;
import com.idorasi.profilematcher.repository.DeviceRepository;
import com.idorasi.profilematcher.repository.InventoryRepository;
import com.idorasi.profilematcher.repository.PlayerRepository;
import jakarta.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class PlayerService {

    private PlayerRepository playerRepository;
    private InventoryRepository inventoryRepository;
    private DeviceRepository deviceRepository;
    private CampaignsClient campaignsClient;

    @Transactional
    public PlayerDto createPlayer(PlayerCreateDto playerCreateDto) {
        final var inventory = inventoryRepository.save(new Inventory());

        var device = deviceRepository.save(new Device()
                .setFirmware(playerCreateDto.device().firmware())
                .setCarrier(playerCreateDto.device().carrier())
                .setModel(playerCreateDto.device().model()));

        final var player = new Player()
                .setPlayerId(UUID.randomUUID())
                .setBirthdate(playerCreateDto.birthdate())
                .setGender(playerCreateDto.gender())
                .setCountry(playerCreateDto.country())
                .setLanguage(playerCreateDto.language())
                .setCredential(playerCreateDto.credential())
                .setDevices(Set.of(device))
                .setLastSession(LocalDateTime.now())
                .setInventory(inventory);

        final var savedPlayer = playerRepository.save(player);

        return convertFromEntity(savedPlayer);
    }

    @Transactional
    public List<PlayerDto> findAllPlayers() {
        return playerRepository.findAll()
                .stream()
                .map(PlayerDtoConverter::convertFromEntity)
                .toList();
    }

    public PlayerDto findPlayer(UUID playerId) {
        var player = getPlayer(playerId);
        return convertFromEntity(player);
    }

    private Player getPlayer(UUID playerId) {
        return playerRepository.findByPlayerId(playerId)
                .orElseThrow(() -> new EntityNotFoundException("Unable to find player by id " + playerId));

    }

    public PlayerDto findPlayerConfig(UUID playerId) {
        var player = getPlayer(playerId);
        var campaigns = campaignsClient.retrieveAllCampaigns();

        var playerCampaigns = campaigns.stream()
                .map(campaignsDto -> checkPlayerCampaignQualification(player, campaignsDto))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toSet());

        return convertFromEntity(player, playerCampaigns);
    }

    private Optional<String> checkPlayerCampaignQualification(Player player, CampaignsDto campaignsDto) {
        if (!campaignsDto.isEnabled()) {
            return Optional.empty();
        }

        var playerItems = player.getInventory().getItems()
                .stream()
                .filter(inventoryItem -> inventoryItem.getCount() > 0)
                .map(inventoryItem -> inventoryItem.getItem().getName())
                .collect(Collectors.toSet());

        var matchers = campaignsDto.getMatchers();

        Predicate<Player> minLevel = p -> p.getLevel() >= matchers.getLevel().getMin();
        Predicate<Player> maxLevel = p -> matchers.getLevel().getMax() == 0 ||
                p.getLevel() <= matchers.getLevel().getMax();

        Predicate<Player> hasItems = p -> validateHasItems(playerItems, matchers.getHas().getItems());

        Predicate<Player> hasCountry = p -> matchers.getHas().getCountry().isEmpty() ||
                matchers.getHas().getCountry().contains(p.getCountry());

        Predicate<Player> doesNotHaveItems = p -> matchers.getDoesNotHave().getItems().isEmpty() ||
                matchers.getDoesNotHave().getItems().stream().noneMatch(playerItems::contains);


        if (minLevel.and(maxLevel).and(hasItems).and(hasCountry).and(doesNotHaveItems).test(player)) {
            return Optional.of(campaignsDto.getName());
        }

        return Optional.empty();
    }

    private boolean validateHasItems(Set<String> playerItems, Set<String> items) {
        if (items.isEmpty()) {
            return true;
        }

        return playerItems.containsAll(items);
    }
}
