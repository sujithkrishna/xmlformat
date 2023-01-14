package com.krishna.model;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class EmployeeList {

	
	private Map<String,Employee> employeeMap = new HashMap<String, Employee>();

	public Map<String, Employee> getEmployeeMap() {
		return employeeMap;
	}

	public void setEmployeeMap(Map<String, Employee> employeeMap) {
		this.employeeMap = employeeMap;
	}
	
	
}
