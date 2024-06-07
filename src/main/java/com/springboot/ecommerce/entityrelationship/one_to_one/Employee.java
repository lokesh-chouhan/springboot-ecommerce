package com.springboot.ecommerce.entityrelationship.one_to_one;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String fname;
    String lname;

    // @OneToOne to make one to one relationship
    // @JoinColumn to make this table will contain foreign key
    // name will be column name
    @OneToOne
    @JoinColumn(name = "laptop_id")
    private WorkStation workStation;
}
