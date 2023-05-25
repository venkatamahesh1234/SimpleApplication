package com.web.service;

import com.web.model.Employee;

public interface EmployeeService {

	public Iterable<Employee> getAllEmployees();

	public void deleteEmployee(int empNo);

	public Employee insertEmployees(Employee emp);

	public Employee getOneEmployee(int empNo);

	public Employee updateEmployee(Employee emp, int empNo);
}
