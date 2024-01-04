package com.tobeto.rentacar.entities.concretes;

import com.tobeto.rentacar.entities.abstracts.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
