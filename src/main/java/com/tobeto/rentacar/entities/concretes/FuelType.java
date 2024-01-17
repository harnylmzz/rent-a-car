package com.tobeto.rentacar.entities.concretes;

import com.tobeto.rentacar.entities.abstracts.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * This class represents a fuel type in the Rent a Car system.
 * Each fuel type has a unique identifier, a type (e.g., petrol, diesel),
 * and is associated with a list of cars that use that fuel type.
 *
 * It extends the base BaseEntity class.
 *
 * @author [Harun Yılmaz]
 */

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "fuel_types")
public class FuelType extends BaseEntity {

    @Column(name = "type")
    private String type;

    @OneToMany(mappedBy = "fuelType", fetch = FetchType.LAZY)
    private List<Car> cars;

}
