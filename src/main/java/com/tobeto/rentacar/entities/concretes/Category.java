package com.tobeto.rentacar.entities.concretes;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.tobeto.rentacar.entities.abstracts.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * This class represents a category in the Rent a Car system.
 * Each category has a unique identifier, a name, and is associated with a list of cars.
 *
 * It extends the base BaseEntity class.
 *
 * @author [Harun Yılmaz]
 */

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "category")
public class Category extends BaseEntity {

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "category")
    @JsonManagedReference
    private List<Car> cars;
}
