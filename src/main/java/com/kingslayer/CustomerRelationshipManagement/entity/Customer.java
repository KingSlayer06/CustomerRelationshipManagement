package com.kingslayer.CustomerRelationshipManagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity @Data
@AllArgsConstructor @NoArgsConstructor
@Table(name = "customer")
public class Customer {
    @Id
    @Column(name = "email")
    private String email;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;
}
