package com.example.app;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="contactDetails")

public class contact {
    @Id
    private int contactId;
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    private int phoneNumber;
    private String address;
    private String email;
    
}

