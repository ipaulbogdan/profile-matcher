package com.idorasi.profilematcher.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.util.Objects;
import lombok.Data;
import lombok.experimental.Accessors;

@Entity
@Data
@Accessors(chain = true)
@Table(name = "devices")
public class Device extends BaseEntity {

    private String model;
    private String carrier;
    private String firmware;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Device device = (Device) o;
        return Objects.equals(model, device.model) && Objects.equals(firmware, device.firmware);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, firmware);
    }
}
