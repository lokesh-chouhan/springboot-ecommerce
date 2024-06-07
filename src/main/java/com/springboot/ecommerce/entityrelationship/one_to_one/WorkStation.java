package com.springboot.ecommerce.entityrelationship.one_to_one;

import jakarta.persistence.*;

@Entity
public class WorkStation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String company;
    String model;

    // mappedBy to make this table as non-owning table
    // "workStation" is name of variable in owning class
    @OneToOne(mappedBy = "workStation")
    // Disable join column as this table wont have foreign key
    //@JoinColumn
    private Employee employee;
}
