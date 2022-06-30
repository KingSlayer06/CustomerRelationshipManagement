package com.kingslayer.CustomerRelationshipManagement.service;

import com.kingslayer.CustomerRelationshipManagement.entity.Customer;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CustomerServiceImplementation implements CustomerService {
    private SessionFactory sessionFactory;
    private Session session;

    @Autowired
    CustomerServiceImplementation(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
    }

    @Transactional
    public List<Customer> findAll() {
        Transaction transaction = session.beginTransaction();
        List<Customer> customers = session.createQuery("from Customer").list();
        transaction.commit();
        return customers;
    }

    @Transactional
    public Customer findById(int id) {
        Transaction transaction = session.beginTransaction();
        Customer customer = session.get(Customer.class, id);
        transaction.commit();
        return customer;
    }

    @Transactional
    public void saveOrUpdate(Customer customer) {
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(customer);
        System.out.println("Added New Customer to Database: " + customer);
        transaction.commit();
    }

    @Transactional
    public void deleteById(int id) {
        Transaction transaction = session.beginTransaction();
        Customer customer = session.get(Customer.class, id);
        session.delete(customer);
        System.out.println("Deleted Customer from Database: " + customer);
        transaction.commit();
    }
}
