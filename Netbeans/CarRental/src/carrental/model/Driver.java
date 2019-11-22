/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrental.model;

import java.io.Serializable;

/**
 *
 * @author Gabor Farkas <info@gfarkas.com>
 */
public class Driver implements Serializable{
    
    private int id;
    private String title;
    private String firstname;
    private String surname;
    private String email;
    private String phonenumber;
    private String flightnumber;

    public Driver() {
    }

    public Driver(int id, String title, String firstname, String surname, String email, String phonenumber, String flightnumber) {
        this.id = id;
        this.title = title;
        this.firstname = firstname;
        this.surname = surname;
        this.email = email;
        this.phonenumber = phonenumber;
        this.flightnumber = flightnumber;
    }
    
    public Driver(String title, String firstname, String surname, String email, String phonenumber, String flightnumber) {
        this.title = title;
        this.firstname = firstname;
        this.surname = surname;
        this.email = email;
        this.phonenumber = phonenumber;
        this.flightnumber = flightnumber;
    }

    public String getFlightnumber() {
        return flightnumber;
    }

    public void setFlightnumber(String flightnumber) {
        this.flightnumber = flightnumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    @Override
    public String toString() {
        return id + ". " + title + " " + firstname + " " + surname + " " + email;
    }
    
    
    
}
