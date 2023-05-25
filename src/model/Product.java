/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author hp
 */
public class Product {

    private int id;
    private String productCode;
    private String name;
    private int quantity;
    private String image;
    private int imPrice;
    private int exPrice;
    private int stockID;

    public Product(int id, String productCode, String name, int quantity, String image, int imPrice, int exPrice, int stockID) {
        this.id = id;
        this.productCode = productCode;
        this.name = name;
        this.quantity = quantity;
        this.image = image;
        this.imPrice = imPrice;
        this.exPrice = exPrice;
        this.stockID = stockID;
    }

    
    public Product(String productCode, String name, int quantity, String image, int imPrice, int exPrice, int stockID) {
        this.productCode = productCode;
        this.name = name;
        this.quantity = quantity;
        this.image = image;
        this.imPrice = imPrice;
        this.exPrice = exPrice;
        this.stockID = stockID;
    }
    
    
    public Product(int id, String productCode, String name, int quantity, String image, int imPrice, int exPrice) {
        this.id = id;
        this.productCode = productCode;
        this.name = name;
        this.quantity = quantity;
        this.image = image;
        this.imPrice = imPrice;
        this.exPrice = exPrice;
    }

    public Product(String productCode, String name, int quantity, String image, int imPrice, int exPrice) {
        this.productCode = productCode;
        this.name = name;
        this.quantity = quantity;
        this.image = image;
        this.imPrice = imPrice;
        this.exPrice = exPrice;
    }

    public Product(int id, String name, int quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

    public Product(String name, int quantity, String image) {
        this.name = name;
        this.quantity = quantity;
        this.image = image;
    }

    public void setStockID(int stockID) {
        this.stockID = stockID;
    }

    public int getStockID() {
        return stockID;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public void setImPrice(int imPrice) {
        this.imPrice = imPrice;
    }

    public void setExPrice(int exPrice) {
        this.exPrice = exPrice;
    }

    public String getProductCode() {
        return productCode;
    }

    public int getImPrice() {
        return imPrice;
    }

    public int getExPrice() {
        return exPrice;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public Product(int id, String name, int quantity, String image) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.image = image;
    }

    public Product(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
