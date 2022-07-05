package com.greatlearning.management.service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.greatlearning.management.entity.Customer;

@Repository
public class CustomerServiceImpl implements CustomerService {
	
	private SessionFactory sessionfactory;
	private Session session;
	
	public CustomerServiceImpl(SessionFactory sessionfactory) {

		this.sessionfactory = sessionfactory;
		try {
			session = this.sessionfactory.getCurrentSession();
		} catch (HibernateException e) {
			session = this.sessionfactory.openSession();
		}

	}
    
	@Override
	@Transactional
	public List<Customer> findAll() {

		List<Customer> custList = session.createQuery("from Customer").list();
		for (Customer s : custList) {
			System.out.println(s);
		}

		return custList;
	}
	
	@Transactional
	public Customer findByid(Integer id) {

		Customer customer = session.get(Customer.class, id);

		return customer;
	}
	
	@Transactional
	public void save(Customer customer) {

		Transaction tr = session.beginTransaction();
		session.saveOrUpdate(customer);
		tr.commit();
	}
	
	@Override
	@Transactional
	public void delete(Customer customer) {
		Transaction tr = session.beginTransaction();
		session.delete(customer);
		tr.commit();

	}
	
	@Override
	@Transactional
	public List<Customer> findByfirstName(String firstName) {
		List<Customer> custList=null;
		String query="";
		if(firstName.length()!=0 )
			query="from Customer where firstName like '%"+firstName+"%' ";
		
		else
			query="from Customer";
		if(query.length()!=0)
		{
			custList=session.createQuery(query).list();
		}
		return custList;
	}
}
