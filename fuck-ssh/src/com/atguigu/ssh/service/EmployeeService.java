package com.atguigu.ssh.service;

import java.util.List;

import com.atguigu.ssh.dao.EmployeeDao;
import com.atguigu.ssh.entities.Employee;



public class EmployeeService {
	
	private EmployeeDao employeeDao;
	
	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	
	
	public List<Employee> getAll(){
		List<Employee> employees = employeeDao.getAll();
//		employees.clear();
		return employees;
	}

	public void deleteEmployee(Integer id){
		employeeDao.delete(id);
	}
	
	public void saveOrUpdate(Employee employee){
		employeeDao.saveOrUpdate(employee);
	}
	public Employee getEmployee(Integer id){
		return employeeDao.getEmployee(id);
	}


	public boolean validateLastName(String lastName) {
		return employeeDao.validateName(lastName);
	}
}
