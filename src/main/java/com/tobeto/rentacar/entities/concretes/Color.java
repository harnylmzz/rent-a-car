package com.tobeto.rentacar.entities.concretes;

import com.tobeto.rentacar.entities.abstracts.BaseEntity;
import com.tobeto.rentacar.entities.concretes.Car;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "colors")
public class Color extends BaseEntity {

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "color")
    private List<Car> cars;
}
