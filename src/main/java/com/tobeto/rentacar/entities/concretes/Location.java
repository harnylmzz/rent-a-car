package com.tobeto.rentacar.entities.concretes;

import com.tobeto.rentacar.entities.abstracts.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * This class represents a location in the Rent a Car system.
 * Each location has a unique identifier, a country code, city, district,
 * and a specific address.
 * It extends the base BaseEntity class.
 *
 * @author [Harun Yılmaz]
 */

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "locations")
public class Location extends BaseEntity {

    @Column(name="country_code")
    private String countryCode;

    @Column(name="city")
    private String city;

    @Column(name="district")
    private String district;

    @Column(name="address")
    private String address;

}
