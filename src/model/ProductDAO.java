/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hp
 */
public class ProductDAO {

    public Connection connection;
    public int count, sotrang, trang = 1;

    public ProductDAO() {
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

    public boolean add(Product product) {
        Connection con = getConnection();
        String sql = "INSERT INTO product(name, quantity, image, productCode, imPrice, exPrice, stockID) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            con.setAutoCommit(false);
            PreparedStatement insertStatement = con.prepareStatement(sql);
            insertStatement.setString(1, product.getName());
            insertStatement.setInt(2, product.getQuantity());
            insertStatement.setString(3, product.getImage());
            insertStatement.setString(4, product.getProductCode());
            insertStatement.setInt(5, product.getImPrice());
            insertStatement.setInt(6, product.getExPrice());
            insertStatement.setInt(7, product.getStockID());
            insertStatement.executeUpdate();
            
            con.commit();
            insertStatement.close();
            return true;
        } catch (SQLException ex) {
            try {
                con.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        } finally {
            try {
                con.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            closeConnection(con);
        }
        return false;
    }

    public boolean edit(Product product) {
        Connection con = getConnection();
        String sql = "UPDATE product set name = ?, quantity = ? , image = ? , productCode = ?, imPrice = ? , exPrice = ? WHERE id = ? ";
        try {
            con.setAutoCommit(false);
            
            PreparedStatement updateStatement = con.prepareStatement(sql);
            updateStatement.setString(1, product.getName());
            updateStatement.setInt(2, product.getQuantity());
            updateStatement.setString(3, product.getImage());
            updateStatement.setString(4, product.getProductCode());
            updateStatement.setInt(5, product.getImPrice());
            updateStatement.setInt(6, product.getExPrice());
            updateStatement.setInt(7, product.getId());
            updateStatement.executeUpdate();
            
            con.commit();
            
            updateStatement.close();
            return true;
        } catch (SQLException ex) {
            try {
                con.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
            System.out.println(ex.getMessage());
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            closeConnection(con);
        }
        return false;
    }

    public boolean delete(int id) {
        Connection con = getConnection();
        String sql = "DELETE FROM product WHERE id = ?";
        try {
            con.setAutoCommit(false);
            PreparedStatement deleteStatement = con.prepareStatement(sql);
            deleteStatement.setInt(1, id);
            deleteStatement.executeUpdate();
            
            con.commit();
            deleteStatement.close();
            return true;
        } catch (SQLException ex) {
            try {
                con.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            closeConnection(con);
        }
        return false;
    }

    public List<Product> getSearchListProductsByName(String search, int trang, int stockId) {
        Connection con = getConnection();
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM qlsp.product WHERE stockID = ? AND name LIKE ? LIMIT ?, 5";
        Product p = null;
        try {
            PreparedStatement searchStatement = con.prepareStatement(sql);
            searchStatement.setInt(1, stockId);
            searchStatement.setString(2, "%" + search + "%");
            searchStatement.setInt(3, trang * 5 - 5);
            ResultSet result = searchStatement.executeQuery(); // Execute the prepared statement
            while (result.next()) {
                int id = result.getInt("id");
                String productCode = result.getString("productCode");
                String name = result.getString("name");
                int quantity = result.getInt("quantity");
                String image = result.getString("image");
                int imPrice = result.getInt("imprice");
                int exPrice = result.getInt("exprice");
                int stockID = result.getInt("stockID");
                p = new Product(id, productCode, name, quantity, image, imPrice, exPrice, stockID);
                products.add(p);
            }
            searchStatement.close();
            result.close();
        } catch (SQLException e) {
            System.out.println("" + e.getMessage());
        } finally {
            closeConnection(con);
        }
        return products;

    }

    public List<Product> getSearchListProductsByBothPrice(int maxPrice, int minPrice, int trang, int stockId) {
        Connection con = getConnection();
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM qlsp.product WHERE exPrice >= ? AND exPrice <= ? AND stockID = ? LIMIT ?, 5";
        Product p = null;
        try {
            PreparedStatement searchStatement = con.prepareStatement(sql);
            searchStatement.setInt(1, minPrice);
            searchStatement.setInt(2, maxPrice);
            searchStatement.setInt(3, stockId);
            searchStatement.setInt(4, trang * 5 - 5);
            ResultSet result = searchStatement.executeQuery(); // Execute the prepared statement
            while (result.next()) {
                int id = result.getInt("id");
                String productCode = result.getString("productCode");
                String name = result.getString("name");
                int quantity = result.getInt("quantity");
                String image = result.getString("image");
                int imPrice = result.getInt("imprice");
                int exPrice = result.getInt("exprice");
                int stockID = result.getInt("stockID");
                p = new Product(id, productCode, name, quantity, image, imPrice, exPrice, stockID);
                products.add(p);
            }
            searchStatement.close();
            result.close();
        } catch (SQLException e) {
            System.out.println("" + e.getMessage());
        } finally {
            closeConnection(con);
        }
        return products;
    }
    
    public List<Product> getSearchListProductsByMinPrice(int minPrice, int trang, int stockId) {
        Connection con = getConnection();
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM qlsp.product WHERE exPrice >= ? AND stockID = ? LIMIT ?, 5";
        Product p = null;
        try {
            PreparedStatement searchStatement = con.prepareStatement(sql);
            searchStatement.setInt(1, minPrice);
            searchStatement.setInt(2, stockId);
            searchStatement.setInt(3, trang * 5 - 5);
            ResultSet result = searchStatement.executeQuery(); // Execute the prepared statement
            while (result.next()) {
                int id = result.getInt("id");
                String productCode = result.getString("productCode");
                String name = result.getString("name");
                int quantity = result.getInt("quantity");
                String image = result.getString("image");
                int imPrice = result.getInt("imprice");
                int exPrice = result.getInt("exprice");
                int stockID = result.getInt("stockID");
                p = new Product(id, productCode, name, quantity, image, imPrice, exPrice, stockID);
                products.add(p);
            }
            searchStatement.close();
            result.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            closeConnection(con);
        }
        return products;
    }

    public Product getProductDetail(int idValue) {
        Connection con = getConnection();
        String sql = "SELECT * FROM qlsp.product WHERE id = ?";
        Product p = null;
        try {
            PreparedStatement searchStatement = con.prepareStatement(sql);
            searchStatement.setInt(1, idValue);
            ResultSet result = searchStatement.executeQuery(); // Execute the prepared statement
            while (result.next()) {
                int id = result.getInt("id");
                String productCode = result.getString("productCode");
                String name = result.getString("name");
                int quantity = result.getInt("quantity");
                String image = result.getString("image");
                int imPrice = result.getInt("imprice");
                int exPrice = result.getInt("exprice");
                int stockID = result.getInt("stockID");
                p = new Product(id, productCode, name, quantity, image, imPrice, exPrice, stockID);
            }
            searchStatement.close();
            result.close();
        } catch (SQLException e) {
            System.out.println("" + e.getMessage());
        } finally {
            closeConnection(con);
        }
        return p;
    }

    public int countDb() {
        String query = "SELECT count(*) from product";
        Connection con = getConnection();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                count = rs.getInt(1);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            closeConnection(con);
        }
        return count;
    }

    public int countSearchByName(String search , int stockID) {
        String query = "SELECT count(*) FROM qlsp.product WHERE name LIKE ? AND stockID = ?";
        Connection con = getConnection();
        int count = 0;

        try {
            PreparedStatement st = con.prepareStatement(query);
            st.setString(1, "%" + search + "%");
            st.setInt(2, stockID);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            closeConnection(con);
        }

        return count;
    }

    public int countSearchByBothPrice(int minPrice, int maxPrice , int stockID) {
        String query = "SELECT count(*) FROM qlsp.product WHERE exPrice >= ? AND exPrice <= ? AND stockID = ?";
        Connection con = getConnection();
        int count = 0;

        try {
            PreparedStatement st = con.prepareStatement(query);
            st.setInt(1, minPrice);
            st.setInt(2, maxPrice);
            st.setInt(3, stockID);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            closeConnection(con);
        }

        return count;
    }

    public int countSearchByMinPriceDb(int minPrice, int stockID) {
        String query = "SELECT count(*) FROM qlsp.product WHERE exPrice >= ? AND stockID = ?";
        Connection con = getConnection();
        int count = 0;

        try {
            PreparedStatement st = con.prepareStatement(query);
            st.setInt(1, minPrice);
            st.setInt(2, stockID);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            closeConnection(con);
        }

        return count;
    }
    
    public List<Product> loadData(int trang, int stockID) {
        Connection con = getConnection();
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM product WHERE stockID = ? LIMIT ?, 5;";
        try {
            PreparedStatement pt = con.prepareStatement(sql);
            pt.setInt(1, stockID);
            pt.setInt(2, trang * 5 - 5);
            ResultSet result = pt.executeQuery();
            while (result.next()) {
                int id = result.getInt("id");
                String productCode = result.getString("productCode");
                String name = result.getString("name");
                int quantity = result.getInt("quantity");
                String image = result.getString("image");
                int imPrice = result.getInt("imprice");
                int exPrice = result.getInt("exprice");
                Product p = new Product(id, productCode, name, quantity, image, imPrice, exPrice);
                products.add(p);
            }
            pt.close();
            result.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            closeConnection(con);
        }
        return products;
    }

    public boolean checkDuplicateCode(String productCodee, int stockID) {
        Connection con = getConnection();
        String sql = "SELECT * FROM qlsp.product WHERE productCode = ? AND stockID = ?";
        try {
            PreparedStatement searchStatement = con.prepareStatement(sql);
            searchStatement.setString(1, productCodee);
            searchStatement.setInt(2, stockID);
            ResultSet result = searchStatement.executeQuery(); // Execute the prepared statement
            while (result.next()) {
                return true; // co sp trung code trong 1 kho
            }
            searchStatement.close();
            result.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            closeConnection(con);
        }
        return false; // ko co sp trung code trong 1 kho
    }

    public Product getDetailProductByPCodeNStockID(String pcode, int stockid) {
        Connection con = getConnection();
        String sql = "SELECT * FROM qlsp.product WHERE productCode = ? AND stockID = ?";
        Product p = null;
        try {
            PreparedStatement searchStatement = con.prepareStatement(sql);
            searchStatement.setString(1, pcode);
            searchStatement.setInt(2, stockid);
            ResultSet result = searchStatement.executeQuery(); // Execute the prepared statement
            while (result.next()) {
                int id = result.getInt("id");
                String productCode = result.getString("productCode");
                String name = result.getString("name");
                int quantity = result.getInt("quantity");
                String image = result.getString("image");
                int imPrice = result.getInt("imprice");
                int exPrice = result.getInt("exprice");
                int stockID = result.getInt("stockID");
                p = new Product(id, productCode, name, quantity, image, imPrice, exPrice, stockID);
            }
            searchStatement.close();
            result.close();
        } catch (SQLException e) {
            System.out.println("" + e.getMessage());
        } finally {
            closeConnection(con);
        }
        return p;
    }
}
