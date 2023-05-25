///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
package model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;

public class ProductTableModel extends AbstractTableModel {

    private List<Product> products;
    private String[] columnNames = {"Id", "Mã sản phẩm", "Tên sản phẩm", "Số lượng sản phẩm", "Giá nhập", "Giá xuất", "Hình ảnh"};

    public ProductTableModel() {
        products = new ArrayList<>();
    }

    public void setData(List<Product> products) {
        this.products = products;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return products.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Product product = products.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return product.getId();
            case 1:
                return product.getProductCode();
            case 2:
                return product.getName();
            case 3:
                return product.getQuantity();
            case 4:
                return product.getImPrice();
            case 5:
                return product.getExPrice();
            case 6:
                ImageIcon imageIcon = new ImageIcon(product.getImage());
                return imageIcon;
            default:
                return null;
        }
    }
}
