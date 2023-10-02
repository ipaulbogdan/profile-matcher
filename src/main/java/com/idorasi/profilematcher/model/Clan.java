package com.idorasi.profilematcher.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "clans")
public class Clan extends BaseEntity {

    private String name;

}
