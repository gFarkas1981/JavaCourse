package model;

import java.io.Serializable;

/**
 *
 * @author Gabor Farkas <info@gfarkas.com>
 */
public class CD implements Serializable{
    
    private String title;
    private String artist;
    private String company;
    private String country;
    private double price;
    private int year;

    public CD() {
    }

    public CD(String title, String artist, String company, String country, double price, int year) {
        this.title = title;
        this.artist = artist;
        this.company = company;
        this.country = country;
        this.price = price;
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "CD{" + "title=" + title + ", artist=" + artist + ", company=" + company + ", country=" + country + ", price=" + price + ", year=" + year + '}';
    }
    
    
    
}
