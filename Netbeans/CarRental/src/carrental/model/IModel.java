/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrental.model;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Gabor Farkas <info@gfarkas.com>
 */
public interface IModel {
    
    List<Car> getAllCar() throws SQLException;
    int updateCar(Car car) throws SQLException;
    int deleteCar(Car car) throws SQLException;
    int addCar(Car car) throws SQLException;
    Map<Integer, Car> getCarMap() throws SQLException;

    
    List<Driver> getAllDriver() throws SQLException;
    int updateDriver(Driver driver) throws SQLException;
    int deleteDriver(Driver driver) throws SQLException;
    int addDriver(Driver driver) throws SQLException;
    Map<Integer, Driver> getDriverMap() throws SQLException;
    
    List<Rental> getAllRental() throws SQLException;
    int updateRental(Rental rental) throws SQLException;
    int deleteRental(Rental rental) throws SQLException;
    int addRental(Rental rental) throws SQLException;
    Map<Integer, Rental> getRentalMap() throws SQLException;

    void close() throws SQLException;
    
}
