package com.idorasi.profilematcher.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.experimental.Accessors;

@Entity
@Data
@Accessors(chain = true)
@Table(name = "inventory_items")
public class InventoryItem extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    private int count;
}
