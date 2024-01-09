package com.tobeto.rentacar.entities.concretes;

import com.tobeto.rentacar.entities.abstracts.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "fuel_types")
public class FuelType extends BaseEntity {

    @Column(name = "type")
    private String type;
}
