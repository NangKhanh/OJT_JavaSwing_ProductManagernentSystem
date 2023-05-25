/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author hp
 */
public class Stock {
    private int stockID;
    private String stockName;
    private String location;
    private String phoneNumber;

    public Stock() {
    }

    public Stock(String stockName, String location, String phoneNumber) {
        this.stockName = stockName;
        this.location = location;
        this.phoneNumber = phoneNumber;
    }

    public Stock(int stockID, String stockName, String location, String phoneNumber) {
        this.stockID = stockID;
        this.stockName = stockName;
        this.location = location;
        this.phoneNumber = phoneNumber;
    }

    public int getStockID() {
        return stockID;
    }

    public String getStockName() {
        return stockName;
    }

    public String getLocation() {
        return location;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setStockID(int stockID) {
        this.stockID = stockID;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    
}
