package com.springboot.ecommerce.entityrelationship.one_to_one;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "laptop")
@Entity
public class WorkStation {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "brand")
    String company;

    @Column(name = "model")
    String model;

    // mappedBy to make this table as non-owning table
    // "workStation" is name of variable in owning class

    //@OneToOne(mappedBy = "workStation")
    // Disable join column as this table wont have foreign key
    //@JoinColumn
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "employee_id")
    private Employee employee;
}
