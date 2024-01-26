package com.tobeto.rentacar.entities.concretes;

import com.tobeto.rentacar.entities.abstracts.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

/**
 * This class represents an image associated with a car in the Rent a Car system.
 * Each image has a unique identifier, an image URL, and is associated with a specific car.
 * It extends the base BaseEntity class.
 *
 * @author [Harun Yılmaz]
 */

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "images")
public class Image extends BaseEntity {

    @Column(name = "image_url")
    private String url;

    @Column(name = "public_id")
    private String publicId;

    @Column(name = "width")
    private int width;

    @Column(name = "height")
    private int height;

    @Column(name = "bytes")
    private int bytes;

    @Column(name = "format")
    private String format;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "car_id")
    private Car car;

}
