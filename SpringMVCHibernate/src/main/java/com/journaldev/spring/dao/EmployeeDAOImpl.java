package com.journaldev.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.journaldev.spring.model.Employee;


@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addEmployee(Employee e) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(e);
		logger.info("Employee saved successfully, Employee Details="+e);
	}

	@Override
	public void updateEmployee(Employee e) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(e);
		logger.info("Employee updated successfully, Employee Details="+e);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> listEmployees() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Employee> employeesList = session.createQuery("from Employee").list(); // HQL
		
		return employeesList;
	}

	@Override
	public Employee getEmployeeById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Employee e = (Employee) session.load(Employee.class, new Integer(id));
		logger.info("Employee loaded successfully, Employee details="+e);
		return e;
	}

	@Override
	public void removeEmployee(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Employee e = (Employee) session.load(Employee.class, new Integer(id));
		if(null != e){
			session.delete(e);
		}
		logger.info("Employee deleted successfully, Employee details="+e);
	}

}
