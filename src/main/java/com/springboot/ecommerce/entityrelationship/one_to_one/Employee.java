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
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "first_name")
    String fname;
    @Column(name = "last_name")
    String lname;

    // @OneToOne to make one to one relationship
    // @JoinColumn to make this table will contain foreign key
    // name will be column name

    //@OneToOne(cascade = CascadeType.PERSIST)
    //@JoinColumn(name = "laptop_id")
    @OneToOne(mappedBy = "employee")
    private WorkStation workStation;
}
