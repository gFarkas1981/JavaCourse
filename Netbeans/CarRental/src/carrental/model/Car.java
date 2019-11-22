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
public class Car implements Serializable{
    
    private int id;
    private String name;
    private int seats;
    private int doors;
    private boolean airConditioning;
    private boolean manualGearbox;

    public Car() {
    }

    public Car(int id, String name, int seats, int doors, boolean airConditioning, boolean manualGearbox) {
        this.id = id;
        this.name = name;
        this.seats = seats;
        this.doors = doors;
        this.airConditioning = airConditioning;
        this.manualGearbox = manualGearbox;
    }
    
    public Car(String name, int seats, int doors, boolean airConditioning, boolean manualGearbox) {
        this.name = name;
        this.seats = seats;
        this.doors = doors;
        this.airConditioning = airConditioning;
        this.manualGearbox = manualGearbox;
    }

    public boolean isManualGearbox() {
        return manualGearbox;
    }

    public void setManualGearbox(boolean manualGearbox) {
        this.manualGearbox = manualGearbox;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    public boolean isAirConditioning() {
        return airConditioning;
    }

    public void setAirConditioning(boolean airConditioning) {
        this.airConditioning = airConditioning;
    }

    @Override
    public String toString() {
        return id + ". " + name;
    }
    
    
    
}
