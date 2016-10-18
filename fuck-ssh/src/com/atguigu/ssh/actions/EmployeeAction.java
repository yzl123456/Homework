package com.atguigu.ssh.actions;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.atguigu.ssh.entities.Employee;
import com.atguigu.ssh.service.DepartmentService;
import com.atguigu.ssh.service.EmployeeService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class EmployeeAction extends ActionSupport implements RequestAware,
		ModelDriven<Employee>, Preparable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private EmployeeService employeeService;
	private DepartmentService departmentService;

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	// 得到所有员工
	public String list() {
		request.put("employees", employeeService.getAll());

		System.out.println(employeeService.getAll());

		return "list";
	}

	// 删除一个员工
	private Integer id;

	public void setId(Integer id) {
		this.id = id;
	}

	private InputStream inputStream;

	public InputStream getInputStream() {
		return inputStream;
	}

	public String delete() throws UnsupportedEncodingException {
		try {
			employeeService.deleteEmployee(id);
			inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
		} catch (Exception e) {
			inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
		}
		return "ajax-success";
	}

	// 新增一个员工
	public String save() {
		if (id == null) {
			model.setCreateTime(new Date());
		}
		employeeService.saveOrUpdate(model);
		return SUCCESS;
	}

	public void prepareSave() {
		if(id==null)
			model = new Employee();
		else model=employeeService.getEmployee(id);
	}

	// 跳转到新增页面
	public String input() {
		request.put("departments", departmentService.getAll());

		return INPUT;
	}

	public void prepareInput() {
		if (id != null) {
			model = employeeService.getEmployee(id);
			System.out.println(1);
		}

	}

	private Map<String, Object> request;

	@Override
	public void setRequest(Map<String, Object> arg0) {
		this.request = arg0;
	}

	@Override
	public void prepare() throws Exception {
	}

	private Employee model;

	@Override
	public Employee getModel() {
		return model;
	}

	private String lastName;
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String validateLastName() throws UnsupportedEncodingException{
		if(employeeService.validateLastName(lastName)){
			inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
		}
		else{
			inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
		}
		
		return "ajax-success";
	}
	
	
	
	
	
}
