package com.idorasi.profilematcher.controller;

import com.idorasi.profilematcher.dto.PlayerCreateDto;
import com.idorasi.profilematcher.dto.PlayerDto;
import com.idorasi.profilematcher.service.PlayerService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/players")
public class PlayerController {

    private PlayerService playerService;

    @PostMapping
    public PlayerDto postPlayer(@RequestBody @Valid PlayerCreateDto playerCreateDto) {
        return playerService.createPlayer(playerCreateDto);
    }

    @GetMapping
    public List<PlayerDto> getPlayers() {
        return playerService.findAllPlayers();
    }

    @GetMapping("/{playerId}")
    public PlayerDto getPlayer(@PathVariable UUID playerId) {
        return playerService.findPlayer(playerId);
    }

    @GetMapping("/get_client_config/{playerId}")
    public PlayerDto getPlayerConfig(@PathVariable UUID playerId) {
        return playerService.findPlayerConfig(playerId);
    }
}

