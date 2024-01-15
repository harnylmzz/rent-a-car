package com.tobeto.rentacar.entities.concretes;

import com.tobeto.rentacar.entities.abstracts.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


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
