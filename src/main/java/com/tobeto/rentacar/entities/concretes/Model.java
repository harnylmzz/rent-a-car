package com.tobeto.rentacar.entities.concretes;

import com.tobeto.rentacar.entities.abstracts.BaseEntity;
import com.tobeto.rentacar.entities.concretes.Brand;
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
@Table(name = "models")
public class Model extends BaseEntity {

    @Column(name = "name")
    private String name;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @OneToMany(mappedBy = "model")
    private List<Car> cars;

}
