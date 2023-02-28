package net.adminPortal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.adminPortal.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
}
