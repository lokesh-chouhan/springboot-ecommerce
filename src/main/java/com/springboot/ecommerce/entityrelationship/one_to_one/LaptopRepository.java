package com.springboot.ecommerce.entityrelationship.one_to_one;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LaptopRepository extends JpaRepository<WorkStation, Integer> {
}
