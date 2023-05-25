/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author hp
 */
public class MyObject {
    private int fromQuantity, toQuantity;
    private String fromProductCode;
    private int fromStockID, toStockID;

    public MyObject() {
    }

    public MyObject(int fromQuantity, int toQuantity, String fromProductCode, int fromStockID, int toStockID) {
        this.fromQuantity = fromQuantity;
        this.toQuantity = toQuantity;
        this.fromProductCode = fromProductCode;
        this.fromStockID = fromStockID;
        this.toStockID = toStockID;
    }

    public int getFromQuantity() {
        return fromQuantity;
    }

    public int getToQuantity() {
        return toQuantity;
    }

    public String getFromProductCode() {
        return fromProductCode;
    }

    public int getFromStockID() {
        return fromStockID;
    }

    public int getToStockID() {
        return toStockID;
    }

    public void setFromQuantity(int fromQuantity) {
        this.fromQuantity = fromQuantity;
    }

    public void setToQuantity(int toQuantity) {
        this.toQuantity = toQuantity;
    }

    public void setFromProductCode(String fromProductCode) {
        this.fromProductCode = fromProductCode;
    }

    public void setFromStockID(int fromStockID) {
        this.fromStockID = fromStockID;
    }

    public void setToStockID(int toStockID) {
        this.toStockID = toStockID;
    }
    
    
}
