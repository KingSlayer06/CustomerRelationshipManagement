package com.kingslayer.CustomerRelationshipManagement.service;

import com.kingslayer.CustomerRelationshipManagement.entity.Customer;

import java.util.List;

public interface CustomerService {
    public List<Customer> findAll();

    public Customer findByEmail(String email);

    public void saveOrUpdate(Customer customer);

    public void deleteByEmail(String email);
}
