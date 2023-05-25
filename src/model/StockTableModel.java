/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author hp
 */
public class StockTableModel extends AbstractTableModel {

    private List<Stock> stocks;
    private String[] columnNames = {"Id", "Tên kho hàng", "Địa điểm", "Số điện thoại"};

    public StockTableModel() {
        stocks = new ArrayList<>();
    }

    public void setData(List<Stock> stocks) {
        this.stocks = stocks;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return stocks.size();
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
        Stock stock = stocks.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return stock.getStockID();
            case 1:
                return stock.getStockName();
            case 2:
                return stock.getLocation();
            case 3:
                return stock.getPhoneNumber();
            default:
                return null;
        }
    }
}
