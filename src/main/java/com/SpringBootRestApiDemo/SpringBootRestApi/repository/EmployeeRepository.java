package com.SpringBootRestApiDemo.SpringBootRestApi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.SpringBootRestApiDemo.SpringBootRestApi.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
	@Query(value = "select * from Employee e where e.name=?1", nativeQuery = true)
	List<Employee> findByName(String name);

}
