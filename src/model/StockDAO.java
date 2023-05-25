/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hp
 */
public class StockDAO {

    public Connection connection;

    public StockDAO() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("can't load driver");
        }
    }

    private Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/qlsp";
        String username = "root";
        String password = "12345";
        try {

            Connection con = (Connection) DriverManager.getConnection(url, username, password);
            System.out.println("Connect successfull");
            return con;
        } catch (SQLException ex) {
            System.out.println("Can't connect database");
            throw new RuntimeException(ex);
        }
    }

    private void closeConnection(Connection con) {
        try {
            con.close();
            System.out.println("db closed");
        } catch (SQLException e) {
            System.out.println("Can't close");
        }
    }

    public boolean add(Stock stock) {
        Connection con = getConnection();
        String sql = "INSERT INTO stock(stockName, location, phoneNumber) VALUES (?, ?, ?)";
        try {
            con.setAutoCommit(false);
            PreparedStatement insertStatement = con.prepareStatement(sql);
            insertStatement.setString(1, stock.getStockName());
            insertStatement.setString(2, stock.getLocation());
            insertStatement.setString(3, stock.getPhoneNumber());
            insertStatement.executeUpdate();
            
            con.commit();
            insertStatement.close();
            return true;
        } catch (SQLException ex) {
            try {
                con.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(StockDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        } finally {
            try {
                con.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(StockDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            closeConnection(con);
        }
        return false;
    }

    public boolean edit(Stock stock) {
        Connection con = getConnection();
        String sql = "UPDATE stock set stockName = ?, location = ?, phoneNumber = ? WHERE stockID = ? ";
        try {
            con.setAutoCommit(false);
            PreparedStatement updateStatement = con.prepareStatement(sql);
            updateStatement.setString(1, stock.getStockName());
            updateStatement.setString(2, stock.getLocation());
            updateStatement.setString(3, stock.getPhoneNumber());
            updateStatement.setInt(4, stock.getStockID());
            updateStatement.executeUpdate();
            con.commit();
            updateStatement.close();
            return true;
        } catch (SQLException ex) {
            try {
                con.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(StockDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
            System.out.println(ex.getMessage());
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(StockDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            closeConnection(con);
        }
        return false;
    }

    public List<Stock> getListStock() {
        Connection con = getConnection();
        List<Stock> stock = new ArrayList<>();
        String sql = "SELECT * FROM qlsp.stock";
        try {
            Statement selectStatement = con.createStatement();
            ResultSet result = selectStatement.executeQuery(sql);
            while (result.next()) {
                int id = result.getInt("stockID");
                String name = result.getString("stockName");
                String location = result.getString("location");
                String phoneNumber = result.getString("phoneNumber");
                Stock s = new Stock(id, name, location, phoneNumber);
                stock.add(s);
            }
            selectStatement.close();
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(con);
        }
        return stock;
    }

    public String getProductStockName(int id) {
        Connection con = getConnection();
        String StockName = null;
        String sql = "SELECT * FROM qlsp.product "
                + "inner join stock on product.stockID = stock.stockID "
                + "WHERE id = ?;";
        try {
            PreparedStatement searchStatement = con.prepareStatement(sql);
            searchStatement.setInt(1, id);
            ResultSet result = searchStatement.executeQuery();
            while (result.next()) {
                StockName = result.getString("stockName");
            }
            searchStatement.close();
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(con);
        }
        return StockName;
    }
    
    
    public Stock getDetailStock(int idValue) {
        Connection con = getConnection();
        String sql = "SELECT * FROM qlsp.stock WHERE stockID = ?";
        Stock stock = null;
        try {
            PreparedStatement searchStatement = con.prepareStatement(sql);
            searchStatement.setInt(1, idValue);
            ResultSet result = searchStatement.executeQuery(); // Execute the prepared statement
            while (result.next()) {
                int stockID = result.getInt("stockID");
                String stockName = result.getString("stockName");
                String location = result.getString("location");
                String phoneNumber = result.getString("phoneNumber");
                stock = new Stock(stockID, stockName, location, phoneNumber);
            }
            searchStatement.close();
            result.close();
        } catch (SQLException e) {
            System.out.println("" + e.getMessage());
        } finally {
            closeConnection(con);
        }
        return stock;
    }
}
