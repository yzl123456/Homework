package com.atguigu.ssh.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.atguigu.ssh.entities.Employee;



public class EmployeeDao extends BaseDao{
	
	
	
	public List<Employee> getAll(){
		String hql="from Employee";
		return getSession().createQuery(hql).list();
	}
	
	public void delete(Integer id){
		String hql="delete from Employee where id=?";
		getSession().createQuery(hql).setInteger(0, id).executeUpdate();
	}
	
	public void saveOrUpdate(Employee employee){
		getSession().saveOrUpdate(employee);
	}
	public Employee getEmployee(Integer id){
		return (Employee) getSession().get(Employee.class, id);
	}

	public boolean validateName(String lastName) {
		String hql = "from Employee e where e.lastName=?";
		Query query = getSession().createQuery(hql).setString(0, lastName);
		Employee employee=(Employee) query.uniqueResult();
		if(employee==null)
			return true;
		else return false;
	}
	
}
