package com.idorasi.profilematcher.model;

import static java.math.BigDecimal.ZERO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import lombok.experimental.Accessors;


@Entity
@Data
@Accessors(chain = true)
@Table(name = "players")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Player extends BaseEntity {

    private UUID playerId;
    private String credential;

    @Setter(AccessLevel.PRIVATE)
    private LocalDateTime created;

    @Setter(AccessLevel.PRIVATE)
    private LocalDateTime modified;

    private LocalDateTime lastSession;
    private BigDecimal totalSpent = ZERO;
    private BigDecimal totalRefund = ZERO;
    private int totalTransactions;
    private LocalDateTime lastPurchase;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "player_id")
    private Set<Device> devices;

    private int level;
    private int xp;
    private int totalPlaytime;
    private String country;
    private String language;
    private LocalDate birthdate;
    private String gender;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inventory_id")
    private Inventory inventory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clan_id")
    private Clan clan;

    @JsonProperty("_customField")
    private String customField;

    @PrePersist
    void prePersist() {
        if (created == null) {
            created = LocalDateTime.now();
        }
    }

    @PreUpdate
    void preUpdate() {
        modified = LocalDateTime.now();
    }
}
