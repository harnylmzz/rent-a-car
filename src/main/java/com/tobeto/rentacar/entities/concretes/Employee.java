package com.tobeto.rentacar.entities.concretes;

import com.tobeto.rentacar.entities.concretes.enums.role.EmployeeType;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

/**
 * This class represents an employee in the Rent a Car system.
 * Each employee has a unique identifier, a salary, and is associated with a user account.
 * <p>
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
@Table(name = "employees")
public class Employee extends User {

    @Column(name = "salary")
    private double salary;

    @Enumerated(EnumType.STRING)
    @Column(name = "employee_type")
    private Set<EmployeeType> employeeType;

}
