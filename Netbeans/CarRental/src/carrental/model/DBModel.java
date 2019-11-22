/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrental.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Gabor Farkas <info@gfarkas.com>
 */
public class DBModel implements IModel {

    private Connection connection;
    private PreparedStatement getAllCarPstmt;
    private PreparedStatement getAllDriverPstmt;
    private PreparedStatement getAllRentalPstmt;
    private PreparedStatement updateCarPstmt;
    private PreparedStatement updateDriverPstmt;
    private PreparedStatement updateRentalPstmt;
    private PreparedStatement deleteCarPstmt;
    private PreparedStatement deleteDriverPstmt;
    private PreparedStatement deleteRentalPstmt;
    private PreparedStatement addCarPstmt;
    private PreparedStatement addDriverPstmt;
    private PreparedStatement addRentalPstmt;

    public DBModel(Connection connection) throws SQLException {

        getAllCarPstmt
                = connection.prepareStatement("SELECT * FROM car");
        getAllDriverPstmt
                = connection.prepareStatement("SELECT * FROM driver");
        getAllRentalPstmt
                = connection.prepareStatement("SELECT * FROM rental");

        updateCarPstmt
                = connection.prepareStatement(
                        "UPDATE car SET name = ?, seats = ?, "
                        + "doors = ?, airconditioning = ?, "
                        + "manualgearbox = ? WHERE id = ?");
        updateDriverPstmt
                = connection.prepareStatement(
                        "UPDATE driver SET title = ?, firstname = ?, "
                        + "surname = ?, email = ?, "
                        + "phonenumber = ?, flightnumber = ? WHERE id = ?");
        updateRentalPstmt
                = connection.prepareStatement(
                        "UPDATE rental SET datefrom = ?, dateto = ?, "
                        + "carid = ?, driverid = ?, "
                        + "price = ? WHERE id = ?");

        deleteCarPstmt
                = connection.prepareStatement("DELETE FROM car WHERE id = ?");
        deleteDriverPstmt
                = connection.prepareStatement("DELETE FROM driver WHERE id = ?");
        deleteRentalPstmt
                = connection.prepareStatement("DELETE FROM rental WHERE id = ?");

        addCarPstmt
                = connection.prepareStatement(
                        "INSERT INTO car "
                        + "(name, seats, doors,"
                        + " airconditioning, manualgearbox) "
                        + "VALUES (?, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
        addDriverPstmt
                = connection.prepareStatement(
                        "INSERT INTO driver "
                        + "(title, firstname, surname, email,"
                        + " phonenumber, flightnumber) "
                        + "VALUES (?, ?, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
        addRentalPstmt
                = connection.prepareStatement(
                        "INSERT INTO rental "
                        + "(datefrom, dateto, carid, driverid, price) "
                        + "VALUES (?, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);

    }

    @Override
    public List<Car> getAllCar() throws SQLException {

        ResultSet resultSet = getAllCarPstmt.executeQuery();
        List<Car> cars = new ArrayList<>();

        while (resultSet.next()) {

            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int seats = resultSet.getInt("seats");
            int doors = resultSet.getInt("doors");
            boolean airConditioning = resultSet.getBoolean("airconditioning");
            boolean manualGearbox = resultSet.getBoolean("manualgearbox");

            Car car = new Car(id, name, seats, doors, airConditioning, manualGearbox);
            cars.add(car);

        }

        resultSet.close();

        return cars;

    }

    @Override
    public int updateCar(Car car) throws SQLException {

        updateCarPstmt.setString(1, car.getName());
        updateCarPstmt.setInt(2, car.getSeats());
        updateCarPstmt.setInt(3, car.getDoors());
        updateCarPstmt.setBoolean(4, car.isAirConditioning());
        updateCarPstmt.setBoolean(5, car.isManualGearbox());
        updateCarPstmt.setInt(6, car.getId());

        return updateCarPstmt.executeUpdate();

    }

    @Override
    public int deleteCar(Car car) throws SQLException {

        deleteCarPstmt.setInt(1, car.getId());

        return deleteCarPstmt.executeUpdate();

    }

    @Override
    public int addCar(Car car) throws SQLException {

        int id = 0;
        
        addCarPstmt.setString(1, car.getName());
        addCarPstmt.setInt(2, car.getSeats());
        addCarPstmt.setInt(3, car.getDoors());
        addCarPstmt.setBoolean(4, car.isAirConditioning());
        addCarPstmt.setBoolean(5, car.isManualGearbox());
        addCarPstmt.executeUpdate();
        
        ResultSet rs = addCarPstmt.getGeneratedKeys();

        if (rs.next()) {
            
            id = rs.getInt(1);
            
        }
        
        return id; 

    }

    @Override
    public Map<Integer, Car> getCarMap() throws SQLException {

        Map<Integer, Car> carMap = new HashMap<>();

        List<Car> cars = getAllCar();

        for (Car car : cars) {

            carMap.put(car.getId(), car);

        }

        return carMap;

    }


    @Override
    public List<Driver> getAllDriver() throws SQLException {

        ResultSet resultSet = getAllDriverPstmt.executeQuery();
        List<Driver> drivers = new ArrayList<>();

        while (resultSet.next()) {

            int id = resultSet.getInt("id");
            String title = resultSet.getString("title");
            String firstName = resultSet.getString("firstname");
            String surname = resultSet.getString("surname");
            String email = resultSet.getString("email");
            String phonenumber = resultSet.getString("phonenumber");
            String flightNumber = resultSet.getString("flightnumber");

            Driver driver = new Driver(id, title, firstName, surname, email, phonenumber, flightNumber);
            drivers.add(driver);

        }

        resultSet.close();

        return drivers;

    }

    @Override
    public int updateDriver(Driver driver) throws SQLException {

        updateDriverPstmt.setString(1, driver.getTitle());
        updateDriverPstmt.setString(2, driver.getFirstname());
        updateDriverPstmt.setString(3, driver.getSurname());
        updateDriverPstmt.setString(4, driver.getEmail());
        updateDriverPstmt.setString(5, driver.getPhonenumber());
        updateDriverPstmt.setString(6, driver.getFlightnumber());
        updateDriverPstmt.setInt(7, driver.getId());

        return updateDriverPstmt.executeUpdate();

    }

    @Override
    public int deleteDriver(Driver driver) throws SQLException {

        deleteDriverPstmt.setInt(1, driver.getId());

        return deleteDriverPstmt.executeUpdate();

    }

    @Override
    public int addDriver(Driver driver) throws SQLException {
        
        int id = 0;

        addDriverPstmt.setString(1, driver.getTitle());
        addDriverPstmt.setString(2, driver.getFirstname());
        addDriverPstmt.setString(3, driver.getSurname());
        addDriverPstmt.setString(4, driver.getEmail());
        addDriverPstmt.setString(5, driver.getPhonenumber());
        addDriverPstmt.setString(6, driver.getFlightnumber());
        addDriverPstmt.executeUpdate();
        
        ResultSet rs = addDriverPstmt.getGeneratedKeys();

        if (rs.next()) {
            
            id = rs.getInt(1);
        }
        
        return id;

    }

    @Override
    public Map<Integer, Driver> getDriverMap() throws SQLException {

        Map<Integer, Driver> driverMap = new HashMap<>();

        List<Driver> drivers = getAllDriver();

        for (Driver driver : drivers) {

            driverMap.put(driver.getId(), driver);

        }

        return driverMap;

    }

    @Override
    public List<Rental> getAllRental() throws SQLException {

        ResultSet resultSet = getAllRentalPstmt.executeQuery();
        List<Rental> rentals = new ArrayList<>();
        Map<Integer, Car> cars = getCarMap();
        Map<Integer, Driver> drivers = getDriverMap();

        while (resultSet.next()) {

            int id = resultSet.getInt("id");
            Timestamp timeStampFrom = resultSet.getTimestamp("datefrom");
            Timestamp timeStampTo = resultSet.getTimestamp("dateto");
            int carID = resultSet.getInt("carid");
            int driverID = resultSet.getInt("driverid");
            int price = resultSet.getInt("price");

            Car car = cars.get(carID);
            Driver driver = drivers.get(driverID);

            Rental rental = new Rental(id, timeStampFrom, timeStampTo, car, driver, price);
            rentals.add(rental);

        }

        resultSet.close();

        return rentals;

    }

    @Override
    public int updateRental(Rental rental) throws SQLException {
    
        updateRentalPstmt.setTimestamp(1, rental.getTimestampFrom());
        updateRentalPstmt.setTimestamp(2, rental.getTimestampTo());
        updateRentalPstmt.setInt(3, rental.getCar().getId());
        updateRentalPstmt.setInt(4, rental.getDriver().getId());
        updateRentalPstmt.setInt(5, rental.getPrice());
        updateRentalPstmt.setInt(6, rental.getId());

        return updateRentalPstmt.executeUpdate();

    }

    @Override
    public int deleteRental(Rental rental) throws SQLException {

        deleteRentalPstmt.setInt(1, rental.getId());

        return deleteRentalPstmt.executeUpdate();

    }

    @Override
    public int addRental(Rental rental) throws SQLException {
        
        int id = 0;

        addRentalPstmt.setTimestamp(1, rental.getTimestampFrom());
        addRentalPstmt.setTimestamp(2, rental.getTimestampTo());
        addRentalPstmt.setInt(3, rental.getCar().getId());
        addRentalPstmt.setInt(4, rental.getDriver().getId());
        addRentalPstmt.setInt(5, rental.getPrice());
        addRentalPstmt.executeUpdate();
        
        ResultSet rs = addRentalPstmt.getGeneratedKeys();

        if (rs.next()) {
            
            id = rs.getInt(1);
        }

        return id;

    }

    @Override
    public Map<Integer, Rental> getRentalMap() throws SQLException {

        Map<Integer, Rental> rentalMap = new HashMap<>();

        List<Rental> rentals = getAllRental();

        for (Rental rental : rentals) {

            rentalMap.put(rental.getId(), rental);

        }

        return rentalMap;

    }

    @Override
    public void close() throws SQLException {

        connection.close();

    }
    
    

}
