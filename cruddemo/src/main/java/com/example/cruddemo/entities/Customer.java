package com.example.cruddemo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotBlank(message = "Name is required")
    private String name;


    @NotBlank(message = "Surname is required")
    private String surname;

    @NotBlank(message = "Email is required")
    private String email;

    @NotBlank(message = "Email is required")
    private String gender;

    @NotBlank(message = "Email is required")
    private String ssn;

    @NotBlank(message = "Email is required")
    private String CityOfResidence;

    @NotBlank(message = "Email is required")
    private String CountryOfResidence;

    public Customer() {
    }

    public Customer(String name, String email, String gender, String ssn, String CityOfResidence, String CountryOfResidence) {
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.ssn = ssn;
        this.CityOfResidence = CityOfResidence;
        this.CountryOfResidence = CountryOfResidence;

    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getSsn() {
        return this.ssn;
    }

    public void setCityOfResidence(String CityOfResidence) {
        this.CityOfResidence = CityOfResidence;
    }

    public void setCountryOfResidence(String CountryOfResidence) {
        this.CountryOfResidence = CountryOfResidence;
    }

    public String getCityOfResidence() {
        return CityOfResidence;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getSurname() {
        return surname;

    }

    public String getGender() {
        return gender;
    }

    public String getCountryOfResidence() {
        return CountryOfResidence;
    }
}
