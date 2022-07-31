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
@Table(name="userResumeDetails")


public class UserResume {

    @Id
    private int userId;
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int contactId;
    private String careerobjective;
    private String academichistory;
    private String myskills;
    private String languagesknown;
    private String workshop;
    private String certification;
   
}
