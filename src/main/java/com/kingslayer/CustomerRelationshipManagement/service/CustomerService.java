package com.kingslayer.CustomerRelationshipManagement.service;

import com.kingslayer.CustomerRelationshipManagement.entity.Customer;

import java.util.List;

public interface CustomerService {
    public List<Customer> findAll();

    public Customer findById(int id);

    public void saveOrUpdate(Customer customer);

    public void deleteById(int id);
}
