/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import model.ComboBoxModel;
import model.Stock;
import model.MyObject;

/**
 *
 * @author hp
 */
public class TransportView extends javax.swing.JDialog {

    /**
     * Creates new form TransportView
     */
    public TransportView() {
        super((java.awt.Frame) null, true);
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        fromStock = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        comboBox = new javax.swing.JComboBox<>();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtNumber = new javax.swing.JTextField();
        txtProductCode = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        quantityLabel = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtFromID = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Vận chuyển");
        setResizable(false);

        jLabel1.setText("Từ kho :");

        fromStock.setText("From");

        jLabel2.setText("Đến Kho :");

        btnSave.setText("Xác nhận ");

        btnCancel.setText("Hủy");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        jLabel3.setText("Nhập số lượng");

        txtProductCode.setEnabled(false);

        jLabel4.setText("Tổng số :");

        quantityLabel.setText("jLabel5");

        jLabel5.setText("thiết bị");

        txtFromID.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fromStock))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(quantityLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtProductCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtFromID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3)
                    .addComponent(btnCancel))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSave, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(txtNumber)))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(quantityLabel)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(fromStock))))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtProductCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFromID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSave)
                    .addComponent(btnCancel))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> comboBox;
    private javax.swing.JLabel fromStock;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel quantityLabel;
    private javax.swing.JTextField txtFromID;
    private javax.swing.JTextField txtNumber;
    private javax.swing.JTextField txtProductCode;
    // End of variables declaration//GEN-END:variables

    public void addTransportListener(ActionListener listener) {
        btnSave.addActionListener(listener);
    }

    public void fillTheField(List<Stock> stocks, String stockName, String pCode, int quantity, int currentStockID) {

        txtProductCode.setVisible(false);
        txtFromID.setVisible(false);
        DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) comboBox.getModel();
        cbbModel.removeAllElements();

        txtNumber.setText("");
        quantityLabel.setText(quantity + "");
        txtProductCode.setText(pCode);
        txtFromID.setText(currentStockID + "");
        fromStock.setText(stockName);
        for (Stock stock : stocks) { //if stockId != currentStockID
            ComboBoxModel mycbb = new ComboBoxModel(stock.getStockID(), stock.getStockName());
            cbbModel.addElement(mycbb);
        }
    }

    public MyObject getDaTa() {
        MyObject data = null;

        String fromProductCode = txtProductCode.getText();

        int fromStockID = Integer.parseInt(txtFromID.getText());
        int toStockID;

        ComboBoxModel temp = (ComboBoxModel) comboBox.getSelectedItem();
        toStockID = temp.MaInt();

        int fromQuantity = Integer.parseInt(quantityLabel.getText());
        int toQuatity = 0;

        try {
            toQuatity = Integer.parseInt(txtNumber.getText());
            if (toQuatity <= 0) {
                throw new Exception();
            }
        } catch (Exception e) {
            showMessage("Vui lòng nhập số lượng là 1 số nguyên dương");
            return null;
        }

        if (fromQuantity < toQuatity) {
            showMessage("Lưu ý : Số lượng thiết bị vận chuyển không thể nhiều hơn số lượng thiết bị đang có trong kho !");
            return null;
        }

        if (fromStockID == toStockID) {
            showMessage("Lưu ý : không thể vận chuyển thiết bị trong cùng 1 kho hàng !");
            return null;
        }

        data = new MyObject(fromQuantity, toQuatity, fromProductCode, fromStockID, toStockID);
        //System.out.println(data.getFromQuantity() + "||" + data.getToQuantity() + "||" + data.getFromProductCode() + "||" + data.getFromStockID() + "||" + data.getToStockID());
        return data;
    }

    public void showMessage(String mess) {
        JOptionPane.showMessageDialog(this, mess);
    }
}
