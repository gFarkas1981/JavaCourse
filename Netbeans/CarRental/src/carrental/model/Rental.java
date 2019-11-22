/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrental.model;

import java.io.Serializable;
import java.sql.Timestamp;


/**
 *
 * @author Gabor Farkas <info@gfarkas.com>
 */
public class Rental implements Serializable {

    int id;
    private Timestamp dateFrom;
    private Timestamp dateTo;
    private Car car;
    private Driver driver;
    int price;

    public Rental() {
    }

    public Rental(int id, Timestamp dateFrom, Timestamp dateTo, Car car, Driver driver, int price) {
        this.id = id;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.car = car;
        this.driver = driver;
        this.price = price;
    }

    public Rental(Timestamp dateFrom, Timestamp dateTo, Car car, Driver driver, int price) {
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.car = car;
        this.driver = driver;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getTimestampFrom() {
        return dateFrom;
    }

    public void setTimestampFrom(Timestamp dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Timestamp getTimestampTo() {
        return dateTo;
    }

    public void setTimestampTo(Timestamp dateTo) {
        this.dateTo = dateTo;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Timestamp getDateFrom() {
        return dateFrom;
    }

    public Timestamp getDateTo() {
        return dateTo;
    }

    public Car getCar() {
        return car;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDateFrom(Timestamp dateFrom) {
        this.dateFrom = dateFrom;
    }

    public void setDateTo(Timestamp dateTo) {
        this.dateTo = dateTo;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }
    
    

}
