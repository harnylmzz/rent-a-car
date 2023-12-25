package com.tobeto.rentacar.entities.abstracts;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

import java.time.LocalDate;

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
