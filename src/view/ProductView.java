/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import model.ImageRenderer;
import model.Product;
import model.ProductTableModel;
import model.ProductDAO;
import java.awt.event.MouseAdapter;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JTextField;
import model.ComboBoxModel;
import model.Stock;

/**
 *
 * @author hp
 */
public class ProductView extends javax.swing.JFrame {

    private ProductTableModel tableModel;
    String imgaeURL = "";
    public int count, sotrang, trang = 1;
    String searchValue = "";
    int[] priceValue = new int[2];
    String typeOfSearchValue = "Tên";
    int stockID ;
    /**
     * Creates new form view
     */
    public ProductView() {
        initComponents();
        this.setLocationRelativeTo(null);
        minLabel.setVisible(false);
        maxLabel.setVisible(false);
        txtMinPrice.setVisible(false);
        txtMaxPrice.setVisible(false);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        productTable = new javax.swing.JTable();
        btnFilter = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtImageURL = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        btnFirst = new javax.swing.JButton();
        btnPrevious = new javax.swing.JButton();
        pageLabel = new javax.swing.JLabel();
        btnNext = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        numberPageLabel = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnGoToStock = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        minLabel = new javax.swing.JLabel();
        txtMinPrice = new javax.swing.JTextField();
        maxLabel = new javax.swing.JLabel();
        txtMaxPrice = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        typeOfSearch = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Products Managerment System");

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        jPanel3.setLayout(new java.awt.GridLayout(1, 0));

        jPanel6.setLayout(new java.awt.BorderLayout());
        jPanel3.add(jPanel6);

        productTable.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        productTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Tên sản phẩm", "Số lượng sản phẩm", "Ảnh"
            }
        ));
        productTable.setAlignmentX(1.0F);
        productTable.setAlignmentY(1.0F);
        productTable.setRowHeight(130);
        productTable.setShowHorizontalLines(true);
        productTable.setShowVerticalLines(true);
        jScrollPane1.setViewportView(productTable);
        if (productTable.getColumnModel().getColumnCount() > 0) {
            productTable.getColumnModel().getColumn(0).setMinWidth(100);
            productTable.getColumnModel().getColumn(0).setMaxWidth(200);
        }

        btnFilter.setText("Lọc sản phẩm");

        jLabel1.setText("Tìm kiếm theo :");

        btnFirst.setText("<<");
        jPanel5.add(btnFirst);

        btnPrevious.setText("<");
        jPanel5.add(btnPrevious);

        pageLabel.setText("jLabel2");
        jPanel5.add(pageLabel);

        btnNext.setText(">");
        jPanel5.add(btnNext);

        btnLast.setText(">>");
        jPanel5.add(btnLast);

        numberPageLabel.setText("jLabel3");
        jPanel5.add(numberPageLabel);

        btnAdd.setText("Thêm sản phẩm");

        btnGoToStock.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnGoToStock.setText("Đến Quản Lý Kho Hàng");

        minLabel.setText("Giá min :");

        maxLabel.setText("Giá max :");

        jLabel4.setText("Kho hàng :");

        typeOfSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tên", "Khoảng giá" }));
        typeOfSearch.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                typeOfSearchItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(610, 610, 610))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(typeOfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(minLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMinPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(maxLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMaxPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnFilter)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                                .addComponent(txtImageURL, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAdd))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnGoToStock, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFilter)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(txtImageURL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(minLabel)
                    .addComponent(txtMinPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(maxLabel)
                    .addComponent(txtMaxPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(typeOfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 672, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(btnGoToStock)
                .addGap(16, 16, 16))
        );

        jPanel1.add(jPanel2);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void typeOfSearchItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_typeOfSearchItemStateChanged
        String selectedOption = typeOfSearch.getSelectedItem().toString();
        if (selectedOption.equals("Tên")) {
            txtSearch.setVisible(true);
            minLabel.setVisible(false);
            maxLabel.setVisible(false);
            txtMinPrice.setVisible(false);
            txtMaxPrice.setVisible(false);
        } else if (selectedOption.equals("Khoảng giá")) {
            txtSearch.setVisible(false);
            minLabel.setVisible(true);
            maxLabel.setVisible(true);
            txtMinPrice.setVisible(true);
            txtMaxPrice.setVisible(true);
        }

        System.out.println("Selected option: " + selectedOption);
    }//GEN-LAST:event_typeOfSearchItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnFilter;
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnGoToStock;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrevious;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel maxLabel;
    private javax.swing.JLabel minLabel;
    private javax.swing.JLabel numberPageLabel;
    private javax.swing.JLabel pageLabel;
    private javax.swing.JTable productTable;
    private javax.swing.JTextField txtImageURL;
    private javax.swing.JTextField txtMaxPrice;
    private javax.swing.JTextField txtMinPrice;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JComboBox<String> typeOfSearch;
    // End of variables declaration//GEN-END:variables

    public void showListProduct(List<Product> products) {
        sotrang = getNumberPage();
        pageLabel.setText("" + trang);
        numberPageLabel.setText(trang + "/" + sotrang);

        txtImageURL.setText(imgaeURL);
        txtImageURL.setVisible(false);
        tableModel = new ProductTableModel();
        productTable.setModel(tableModel);
        productTable.getColumnModel().getColumn(0).setWidth(0);
        productTable.getColumnModel().getColumn(0).setMinWidth(0);
        productTable.getColumnModel().getColumn(0).setMaxWidth(0);
        productTable.getColumnModel().getColumn(6).setCellRenderer(new ImageRenderer());
        tableModel.setData(products);
    }

    public void fillToComboBox(List<Stock> stocks) {
        DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) jComboBox1.getModel();
        cbbModel.removeAllElements();
//        ComboBoxModel mycbbAll = new ComboBoxModel(-1, "Tất cả");
//        cbbModel.addElement(mycbbAll);
        for (Stock stock : stocks) {
            ComboBoxModel mycbb = new ComboBoxModel(stock.getStockID(), stock.getStockName());
            cbbModel.addElement(mycbb);
        }
    }

    public int getStockID(){
        return stockID;
    }
    
    public void setStockFilterID() {
        ComboBoxModel temp = (ComboBoxModel) jComboBox1.getSelectedItem();
        stockID = temp.MaInt();
    }

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue() {
        searchValue = txtSearch.getText();
    }

    public int[] getPriceValue() {
        return priceValue;
    }

    public void setPriceValue() {
        if (!txtMinPrice.getText().isEmpty()) {
            try {
                System.out.println(txtMinPrice.getText());
                priceValue[0] = Integer.parseInt(txtMinPrice.getText());
                if (priceValue[0] < 0) {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("mess : " + e.getMessage());
                JOptionPane.showMessageDialog(this, "Vui lòng nhập giá min là chữ số nguyên dương !");
                txtMinPrice.setText("");
                priceValue[0] = -2;
                priceValue[1] = -2;

                return;
            }
        } else {
            priceValue[0] = -1;
        }

        if (!txtMaxPrice.getText().isEmpty()) {
            try {
                priceValue[1] = Integer.parseInt(txtMaxPrice.getText());
                if (priceValue[1] < 0) {
                    throw new Exception();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập giá max là chữ số nguyên dương !");
                txtMaxPrice.setText("");
                priceValue[0] = -2;
                priceValue[1] = -2;
                return;
            }
        } else {
            priceValue[1] = -1;
        }

        System.out.println(priceValue[0] + "|||" + priceValue[1] + "|||");
    }

    public int getPage() {
        return trang;
    }

    public int getNumberPage() {
        if (getTypeOfSearch().equals("Tên")) {
            String searchvalue = getSearchValue();
            count = new ProductDAO().countSearchByName(searchvalue, stockID);
            if (count % 5 == 0) {
                sotrang = count / 5;
            } else {
                sotrang = count / 5 + 1;
            }
        } else if (getTypeOfSearch().equals("Khoảng giá")) {
            int[] price = getPriceValue();
            if (price[1] != -1) {
                count = new ProductDAO().countSearchByBothPrice(price[0], price[1] , stockID);
            } else {
                count = new ProductDAO().countSearchByMinPriceDb(price[0] , stockID);
            }
            System.out.println(count);
            if (count % 5 == 0) {
                sotrang = count / 5;
            } else {
                sotrang = count / 5 + 1;
            }
        }
        return sotrang;
    }

    public String getTypeOfSearch() {
        return typeOfSearchValue;
    }

    public void setTypeOfSearch() {
        typeOfSearchValue = typeOfSearch.getSelectedItem().toString();
    }

    public void setNextPage() {
        trang++;
    }

    public void setPreviousPage() {
        trang--;
    }

    public void setFirstPage() {
        trang = 1;
    }

    public void setLastPage() {
        trang = getNumberPage();
    }

    public void addFirstPageListiener(ActionListener listener) {
        btnFirst.addActionListener(listener);
    }

    public void addLastPageListiener(ActionListener listener) {
        btnLast.addActionListener(listener);
    }

    public void addNextPageListiener(ActionListener listener) {
        btnNext.addActionListener(listener);
    }

    public void addPreviousPageListiener(ActionListener listener) {
        btnPrevious.addActionListener(listener);
    }

    public void addToAddProductViewListiener(ActionListener listener) {
        btnAdd.addActionListener(listener);
    }

    public void addFilterProductListiener(ActionListener listener) {
        btnFilter.addActionListener(listener);
    }

    public void addTableSelectionListener(MouseAdapter listener) {
        productTable.addMouseListener(listener);
    }

    public void addGoToStockView(ActionListener listiener) {
        btnGoToStock.addActionListener(listiener);
    }

    public void showMessage(String mess) {
        JOptionPane.showMessageDialog(this, mess);
    }

    public int getDataSelected() {
        int row = productTable.getSelectedRow();

        if (row >= 0) {
            int id = Integer.parseInt(productTable.getValueAt(row, 0).toString());
            return id;
        }
        return 0;
    }

    public void resetAllFields() {
        txtMaxPrice.setText("");
        txtMinPrice.setText("");
        txtSearch.setText("");
        
        System.out.println(txtMaxPrice);
        System.out.println(txtSearch);
        setSearchValue();
        setPriceValue();
        System.out.println(priceValue[1]);
    }
}