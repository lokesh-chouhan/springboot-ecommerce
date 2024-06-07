package com.springboot.ecommerce.entityrelationship.one_to_one;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
