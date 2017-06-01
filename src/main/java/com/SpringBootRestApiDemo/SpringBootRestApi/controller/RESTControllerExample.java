package com.SpringBootRestApiDemo.SpringBootRestApi.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.SpringBootRestApiDemo.SpringBootRestApi.model.Employee;
import com.SpringBootRestApiDemo.SpringBootRestApi.repository.EmployeeRepository;

@RestController
public class RESTControllerExample {
	public static final Logger logger = LoggerFactory.getLogger(EmployeeRepository.class);

	@Autowired
	private EmployeeRepository emprepo;

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public ResponseEntity<List<Employee>> getAll() {
		List<Employee> emplist = emprepo.findAll();
		if (emplist.isEmpty()) {
			return new ResponseEntity<List<Employee>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Employee>>(emplist, HttpStatus.OK);
	}

	@PostConstruct
	public void insert() {
		Employee emp = new Employee(1, "Asmita", 20);
		Employee emp1 = new Employee(2, "Alina", 25);
		emprepo.save(emp);
		emprepo.save(emp1);
	}

	@RequestMapping(value = "/employees", method = RequestMethod.POST)
	public ResponseEntity<List<Employee>> retrieve(@RequestBody Employee emp) {
		emp = emprepo.save(emp);
		return new ResponseEntity<List<Employee>>(HttpStatus.CREATED);
	}

	@RequestMapping(value = "/employees/{name}", method = RequestMethod.GET)
	public ResponseEntity<List<Employee>> retrieveCustom(@PathVariable("name") String name) {
		List<Employee> emp = emprepo.findByName(name);
		return new ResponseEntity<List<Employee>>(emp,HttpStatus.CREATED);
	}

}
