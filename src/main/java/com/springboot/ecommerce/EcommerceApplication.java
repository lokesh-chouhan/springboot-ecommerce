package com.springboot.ecommerce;

import com.springboot.ecommerce.entityrelationship.one_to_one.Employee;
import com.springboot.ecommerce.entityrelationship.one_to_one.EmployeeRepository;
import com.springboot.ecommerce.entityrelationship.one_to_one.LaptopRepository;
import com.springboot.ecommerce.entityrelationship.one_to_one.WorkStation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(
		exclude = {
		org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class
		})
public class EcommerceApplication {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	LaptopRepository laptopRepository;

	public static void main(String[] args) {

		SpringApplication.run(EcommerceApplication.class, args);
	}

	@Bean
	public CommandLineRunner initializzeData(){

		return (args -> {


			Employee employee = Employee.builder()
					.fname("lokesh")
					.lname("chouhan")
					.build();

			Employee employee1 = Employee.builder()
					.fname("Tejas")
					.lname("chouhan")
					.build();

			//relation owner entity
			WorkStation laptop = WorkStation.builder()
					.company("Dell")
					.model("m1")
					.build();

			//employee.setWorkStation(laptop);
			//laptop.setEmployee(employee);

			employeeRepository.save(employee);
			employeeRepository.save(employee1);
			laptopRepository.save(laptop);

			Employee e = employeeRepository.findById(1).get();
			//e.setFname("lucky");
			//employeeRepository.save(e);

			WorkStation l = laptopRepository.findById(1).get();
			l.setEmployee(e);
			laptopRepository.save(l);

			System.out.println(laptopRepository.findById(1).get().getEmployee().getFname());

			 l = laptopRepository.findById(1).get();
			l.setEmployee(employee1);
			laptopRepository.save(l);

			System.out.println(laptopRepository.findById(1).get().getEmployee().getFname());


		});
	}

}
