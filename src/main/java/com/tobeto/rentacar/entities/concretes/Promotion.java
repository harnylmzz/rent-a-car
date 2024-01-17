package com.tobeto.rentacar.entities.concretes;

import com.tobeto.rentacar.entities.abstracts.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * This class represents a promotion in the Rent a Car system.
 * Each promotion has a code, discount amount, type, and a description.
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
@Table(name = "promotions")
public class Promotion extends BaseEntity {

    @Column(name = "code")
    private String code;

    @Column(name = "discount")
    private String discount;

    @Column(name = "type")
    private String type;

    @Column(name = "description")
    private String description;

}
