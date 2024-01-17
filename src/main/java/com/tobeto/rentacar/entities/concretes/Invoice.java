package com.tobeto.rentacar.entities.concretes;

import com.tobeto.rentacar.entities.abstracts.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * This class represents an invoice in the Rent a Car system.
 * Each invoice has a unique identifier, a number, an amount, and a VAT (Value Added Tax) value.
 * It extends the base BaseEntity class.
 *
 * @author [Harun Yılmaz]
 */

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "invoices")
public class Invoice extends BaseEntity {

    @Column(name = "number")
    private String number;

    @Column(name = "amount")
    private int amount;

    @Column(name = "vat")
    private String vat;
}
