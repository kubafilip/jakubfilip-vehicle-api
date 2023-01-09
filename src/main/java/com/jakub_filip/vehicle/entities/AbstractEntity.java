package com.jakub_filip.vehicle.entities;

import javax.persistence.*;
import java.util.UUID;

@MappedSuperclass
public abstract class AbstractEntity {

    @Id
    @GeneratedValue(
        strategy = GenerationType.AUTO
    )
    @Column(
        name = "id"
    )
    private UUID id;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
