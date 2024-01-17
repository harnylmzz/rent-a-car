package com.tobeto.rentacar.entities.abstracts;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

import java.time.LocalDate;

/**
 * This abstract class serves as the base entity for all entities in the Rent a Car system.
 * It defines common fields such as a unique identifier, creation date, and update date.
 * Entities that extend this class inherit these common fields and behavior.
 * The class is annotated with MappedSuperclass to indicate that it is not an entity itself.
 *
 * @author [Harun Yılmaz]
 */

@MappedSuperclass
@Data
public abstract class BaseEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int id;

    private LocalDate createdDate;

    private LocalDate updatedDate;

    private void beforeAdd() {
        this.createdDate = LocalDate.now();
    }

    private void beforeUpdate() {
        this.updatedDate = LocalDate.now();
    }

}
