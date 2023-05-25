/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import javax.swing.JOptionPane;
import view.ProductView;
import model.ProductDAO;
import model.Product;
import model.Stock;
import model.StockDAO;
import view.ProductAddView;
import view.ProductEditView;
import view.StockView;
import view.TransportView;
import model.MyObject;
import view.StockAddView;
import view.StockEditView;

/**
 *
 * @author hp
 */
public class Controller {

    private final ProductAddView productAddView;
    private final ProductView productView;
    private final ProductDAO productDAO;
    private final ProductEditView productEditView;
    private final StockView stockView;
    private final StockDAO stockDAO;
    private final TransportView transportView;
    private final StockAddView stockAddView;
    private final StockEditView stockEditView;

    public Controller(ProductView view) {
        this.productView = view;
        productEditView = new ProductEditView();
        productDAO = new ProductDAO();
        productAddView = new ProductAddView();
        stockView = new StockView();
        stockDAO = new StockDAO();
        transportView = new TransportView();
        stockAddView = new StockAddView();
        stockEditView = new StockEditView();

        productAddView.addAddProductListiener(new AddProductListiener());
        
        productEditView.addEditProductListiener(new EditProductListiener());
        productEditView.addDeleleProductListiener(new DeleteProductListiener());
        productEditView.addGoToTransportListiener(new GoToTransportListiener());

        transportView.addTransportListener(new TransportListener());

        productView.addToAddProductViewListiener(new GoToAddProductView());
        productView.addTableSelectionListener(new TableSelectionListener());
        productView.addFilterProductListiener(new FilterListener());
        productView.addNextPageListiener(new NextPageListiener());
        productView.addPreviousPageListiener(new PreviousPageListiener());
        productView.addFirstPageListiener(new FirstPageListiener());
        productView.addLastPageListiener(new LastPageListiener());
        productView.addGoToStockView(new GotoStockView());

        stockView.addGoToProductViewListener(new GoToProductView());
        stockView.addGotoAddStockListener(new GotoStockAddView());
        stockView.addTableSelectionListener(new StockTableSelectionListener());

        stockAddView.addAddStockListener(new AddStocklistener());

        stockEditView.addUpdateStockListener(new UpdateStockListener());
    }

    public void showProductView() {
        int trang = productView.getPage();

        List<Stock> stocks = stockDAO.getListStock();
        int stockID = productView.getStockID();
        List<Product> products = productDAO.loadData(trang, stockID);
        productView.showListProduct(products);
        productView.setVisible(true);
    }

    public void startProgram() {
        int trang = productView.getPage();

        List<Stock> stocks = stockDAO.getListStock();
        productView.fillToComboBox(stocks);
        productView.setStockFilterID();
        int stockID = productView.getStockID();
        List<Product> products = productDAO.loadData(trang, stockID);
        productView.showListProduct(products);
        productView.setVisible(true);
    }

    class GoToAddProductView implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            List<Stock> stocks = stockDAO.getListStock();
            productAddView.fillToComboBox(stocks);
            productAddView.setVisible(true);
        }

    }

    class GotoStockView implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            List<Stock> stocks = stockDAO.getListStock();
            stockView.ShowStockList(stocks);
            productView.setVisible(false);
            stockView.setVisible(true);
        }

    }

    class GoToProductView implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            productView.resetAllFields();
            int trang;
            int sotrang = productView.getNumberPage();
            System.out.println(sotrang);
            trang = 1;
            List<Stock> stocks = stockDAO.getListStock();
            productView.fillToComboBox(stocks);
            productView.setStockFilterID();
            int stockID = productView.getStockID();
            List<Product> products = productDAO.loadData(trang, stockID);
            productView.setFirstPage();
            productView.showListProduct(products);
            stockView.setVisible(false);
            productView.setVisible(true);
        }

    }

    class GoToTransportListiener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int id = productEditView.getProductId();
            Product p = productDAO.getProductDetail(id);
            String stockName = stockDAO.getProductStockName(id);
            List<Stock> stocks = stockDAO.getListStock();
            transportView.fillTheField(stocks, stockName, p.getProductCode(), p.getQuantity(), p.getStockID());
            transportView.setVisible(true);
        }

    }

    class GotoStockAddView implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            stockAddView.setVisible(true);
        }

    }

    class AddProductListiener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Product product = productAddView.getProductData();

            if (product != null) {
                String extractURL = extractFileName(product.getImage());
                String[] temp = extractURL.split("\\.");
                String imageFolderURL = "D:\\Java_Swing\\tonghop\\src\\image\\" + product.getProductCode() + "_Sid_" + product.getStockID() + "." + temp[1];
                copyFile(product.getImage(), imageFolderURL);
                product.setImage(imageFolderURL);
                System.out.println(product.getImage());
                boolean success = productDAO.add(product);
                if (success) {
                    productAddView.showMessage("Thêm thành công");
                    int trang = productView.getNumberPage();
                    productAddView.setNullField();
                    productAddView.setVisible(false);
                    showProductView();
                } else {
                    productAddView.showMessage("Thêm thất bại");
                }
            }
        }
    }

    class EditProductListiener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Product product = productEditView.getProductData();
            Product tempProduct = productDAO.getProductDetail(product.getId());
            int sID = tempProduct.getStockID();
            if (product != null) {
                String extractURL = extractFileName(product.getImage());
                String[] temp = extractURL.split("\\.");
                String imageFolderURL = "D:\\Java_Swing\\tonghop\\src\\image\\" + product.getProductCode() + "_Sid_" + sID + "." + temp[1];
                copyFile(product.getImage(), imageFolderURL);
                product.setImage(imageFolderURL);
                boolean success = productDAO.edit(product);
                if (success) {
                    productEditView.showMessage("Thay đổi thành công");
                    productEditView.setVisible(false);
                    showProductView();
                } else {
                    productEditView.showMessage("Thay đổi thất bại");
                }
            }
        }
    }

    class DeleteProductListiener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int id = productEditView.getProductId();
            Product product = productDAO.getProductDetail(id);

            String[] options = {"Có", "Không"};
            if (product != null) {
                int result = JOptionPane.showOptionDialog(productEditView, "Bạn có chắc chắn muốn xóa không", "Xóa sản phẩm",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[0]);
                if (result == JOptionPane.YES_OPTION) {
                    boolean success = productDAO.delete(id);
                    if (success) {
                        System.out.println(product.getImage());
                        deleteFile(product.getImage());
                        productEditView.showMessage("Xóa thành công");
                        productEditView.setVisible(false);
                        showProductView();
                    } else {
                        productEditView.showMessage("Xóa đổi thất bại");
                    }
                    System.out.println("yes");
                } else if (result == JOptionPane.NO_OPTION) {
                    System.out.println("no");
                }

            }
        }

    }

    class TransportListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            MyObject data = transportView.getDaTa();

            if (data != null) {

                int fromID = productEditView.getProductId();
                int toStockID = data.getToStockID();
                int fromQuantity = data.getFromQuantity();
                int toQuantity = data.getToQuantity();

                fromQuantity = fromQuantity - toQuantity;
                System.out.println("data object");
                if (productDAO.checkDuplicateCode(data.getFromProductCode(), data.getToStockID())) {
                    System.out.println("co roi cap nhat lai");

                    Product fromProduct = productDAO.getProductDetail(fromID);
                    fromProduct.setQuantity(fromQuantity);
                    productDAO.edit(fromProduct);

                    Product toProduct = productDAO.getDetailProductByPCodeNStockID(data.getFromProductCode(), data.getToStockID());

                    int finalToQuantity = toProduct.getQuantity() + toQuantity;
                    toProduct.setQuantity(finalToQuantity);
                    productDAO.edit(toProduct);

                    transportView.showMessage("Vận chuyển thành công");
                    transportView.dispose();
                    productEditView.dispose();
                    showProductView();
                } else {

                    Product fromProduct = productDAO.getProductDetail(fromID);
                    Product toProduct = productDAO.getProductDetail(fromID);

                    toProduct.setQuantity(toQuantity);
                    toProduct.setStockID(toStockID);
                    fromProduct.setQuantity(fromQuantity);

                    String extractURL = extractFileName(toProduct.getImage());
                    String[] temp = extractURL.split("\\.");
                    String imageFolderURL = "D:\\Java_Swing\\tonghop\\src\\image\\" + toProduct.getProductCode() + "_Sid_" + toProduct.getStockID() + "." + temp[1];
                    copyFile(toProduct.getImage(), imageFolderURL);
                    productDAO.add(toProduct);
                    
                    productDAO.edit(fromProduct);

                    transportView.showMessage("Vận chuyển thành công");
                    transportView.dispose();
                    productEditView.dispose();
                    showProductView();
                }
            } else {
                System.out.println("null object");
            }
        }
    }

    class AddStocklistener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Stock stock = stockAddView.getStockData();
            if (stock != null) {

                boolean success = stockDAO.add(stock);
                if (success) {
                    stockAddView.showMessage("Thêm mới kho hàng thành công");
                    List<Stock> stocks = stockDAO.getListStock();
                    stockAddView.clearData();
                    stockAddView.dispose();
                    stockView.ShowStockList(stocks);
                    stockView.setVisible(true);
                }
            }
        }

    }

    class UpdateStockListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Stock stock = stockEditView.getStockData();
            if (stock != null) {
                boolean success = stockDAO.edit(stock);
                if (success) {
                    stockAddView.showMessage("Cập nhật kho hàng thành công");
                    List<Stock> stocks = stockDAO.getListStock();
                    stockEditView.dispose();
                    stockView.ShowStockList(stocks);
                    stockView.setVisible(true);
                }
            }
        }

    }

    class TableSelectionListener extends MouseAdapter {

        private static final int DOUBLE_CLICK = 2;

        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getClickCount() == DOUBLE_CLICK) { //if product != null
                int id = productView.getDataSelected();
                Product p = productDAO.getProductDetail(id);
                productEditView.showDetailProduct(p);
                productEditView.setVisible(true);
            }
        }
    }

    class StockTableSelectionListener extends MouseAdapter {

        private static final int DOUBLE_CLICK = 2;

        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getClickCount() == DOUBLE_CLICK) {
                int id = stockView.getDataSelected();
                Stock stock = stockDAO.getDetailStock(id);
                stockEditView.setVisible(true);
                stockEditView.fillTheFields(stock);
            }
        }

    }

    class FilterListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int trang = 1;
            int sotrang = productView.getNumberPage();
            productView.setStockFilterID();
            int stockID = productView.getStockID();
            productView.setTypeOfSearch();
            productView.setFirstPage();
            System.out.println(productView.getTypeOfSearch());
            if (productView.getTypeOfSearch().equals("Tên")) {
                productView.setSearchValue();
                String searchvalue = productView.getSearchValue();
                List<Product> products = productDAO.getSearchListProductsByName(searchvalue, trang, stockID);
                productView.showListProduct(products);
                productView.setVisible(true);
            } else if (productView.getTypeOfSearch().equals("Khoảng giá")) {
                productView.setPriceValue();
                int[] priceValue = productView.getPriceValue();
                int minPrice = priceValue[0];
                int maxPrice = priceValue[1];
                if (minPrice != -2 || maxPrice != -2) {
                    List<Product> products = null;

                    if (maxPrice != -1) {
                        products = productDAO.getSearchListProductsByBothPrice(maxPrice, minPrice, trang, stockID);
                    } else if (maxPrice == -1) {
                        products = productDAO.getSearchListProductsByMinPrice(minPrice, trang, stockID);
                    }

                    System.out.println(minPrice + "|||" + maxPrice + "|||");
                    productView.showListProduct(products);
                    productView.setVisible(true);
                }
            }
        }

    }

    class NextPageListiener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int trang = productView.getPage();
            int sotrang = productView.getNumberPage();
            System.out.println(sotrang);
            int stockID = productView.getStockID();
            if (trang < sotrang) {
                if (productView.getTypeOfSearch().equals("Tên")) {
                    trang++;
                    String searchvalue = productView.getSearchValue();
                    List<Product> products = productDAO.getSearchListProductsByName(searchvalue, trang, stockID);
                    productView.setNextPage();
                    productView.showListProduct(products);
                    productView.setVisible(true);
                } else if (productView.getTypeOfSearch().equals("Khoảng giá")) {
                    int[] priceValue = productView.getPriceValue();
                    int minPrice = priceValue[0];
                    int maxPrice = priceValue[1];
                    if (minPrice != -2 || maxPrice != -2) {
                        List<Product> products = null;
                        if (maxPrice != -1) {
                            trang++;
                            products = productDAO.getSearchListProductsByBothPrice(maxPrice, minPrice, trang, stockID);
                            productView.setNextPage();
                            productView.showListProduct(products);
                            productView.setVisible(true);
                        }
                        if (maxPrice == -1) {
                            trang++;
                            products = productDAO.getSearchListProductsByMinPrice(minPrice, trang, stockID);
                            productView.setNextPage();
                            productView.showListProduct(products);
                            productView.setVisible(true);
                        }
                    }
                }
            }
        }
    }

    class PreviousPageListiener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int trang = productView.getPage();
            int sotrang = productView.getNumberPage();
            System.out.println(sotrang);
            int stockID = productView.getStockID();
            if (trang > 1) {
                if (productView.getTypeOfSearch().equals("Tên")) {
                    trang--;
                    String searchvalue = productView.getSearchValue();
                    List<Product> products = productDAO.getSearchListProductsByName(searchvalue, trang, stockID);
                    productView.setPreviousPage();
                    productView.showListProduct(products);
                    productView.setVisible(true);
                } else if (productView.getTypeOfSearch().equals("Khoảng giá")) {
                    int[] priceValue = productView.getPriceValue();
                    int minPrice = priceValue[0];
                    int maxPrice = priceValue[1];
                    if (minPrice != -2 || maxPrice != -2) {
                        List<Product> products = null;
                        if (maxPrice != -1) {
                            trang--;
                            products = productDAO.getSearchListProductsByBothPrice(maxPrice, minPrice, trang, stockID);
                            productView.setPreviousPage();
                            productView.showListProduct(products);
                            productView.setVisible(true);
                        } else if (maxPrice == -1) {
                            trang--;
                            products = productDAO.getSearchListProductsByMinPrice(minPrice, trang, stockID);
                            productView.setPreviousPage();
                            productView.showListProduct(products);
                            productView.setVisible(true);
                        }
                    }
                }
            }
        }
    }

    class FirstPageListiener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int trang;
            int sotrang = productView.getNumberPage();
            System.out.println(sotrang);
            int stockID = productView.getStockID();
            trang = 1;
            if (productView.getTypeOfSearch().equals("Tên")) {
                String searchvalue = productView.getSearchValue();
                List<Product> products = productDAO.getSearchListProductsByName(searchvalue, trang, stockID);
                productView.setFirstPage();
                productView.showListProduct(products);
                productView.setVisible(true);
            } else if (productView.getTypeOfSearch().equals("Khoảng giá")) {
                int[] priceValue = productView.getPriceValue();
                int minPrice = priceValue[0];
                int maxPrice = priceValue[1];
                if (minPrice != -2 || maxPrice != -2) {
                    List<Product> products = null;
                    if (maxPrice != -1) {
                        products = productDAO.getSearchListProductsByBothPrice(maxPrice, minPrice, trang, stockID);
                        productView.setFirstPage();
                        productView.showListProduct(products);
                        productView.setVisible(true);
                    } else if (maxPrice == -1) {
                        products = productDAO.getSearchListProductsByMinPrice(minPrice, trang, stockID);
                        productView.setFirstPage();
                        productView.showListProduct(products);
                        productView.setVisible(true);
                    }
                }
            }
        }
    }

    class LastPageListiener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int trang = productView.getNumberPage();
            int stockID = productView.getStockID();
            if (productView.getTypeOfSearch().equals("Tên")) {
                String searchvalue = productView.getSearchValue();
                List<Product> products = productDAO.getSearchListProductsByName(searchvalue, trang, stockID);
                productView.setLastPage();
                productView.showListProduct(products);
                productView.setVisible(true);
            } else if (productView.getTypeOfSearch().equals("Khoảng giá")) {
                int[] priceValue = productView.getPriceValue();
                int minPrice = priceValue[0];
                int maxPrice = priceValue[1];
                if (minPrice != -2 || maxPrice != -2) {
                    List<Product> products = null;
                    if (maxPrice != -1) {
                        products = productDAO.getSearchListProductsByBothPrice(maxPrice, minPrice, trang, stockID);
                        productView.setLastPage();
                        productView.showListProduct(products);
                        productView.setVisible(true);
                    } else if (maxPrice == -1) {
                        products = productDAO.getSearchListProductsByMinPrice(minPrice, trang, stockID);
                        productView.setLastPage();
                        productView.showListProduct(products);
                        productView.setVisible(true);
                    }
                }
            }
        }
    }

    static void deleteFile(String fileURL) {
        try {
            File file = new File(fileURL);
            if (file.delete()) {
                System.out.println(file.getName() + " is deleted!");
            } else {
                System.out.println("Delete operation is failed.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void copyFile(String sourcePath, String destinationPath) {
        try {
            Path source = Paths.get(sourcePath);
            Path destination = Paths.get(destinationPath);
            Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File copied successfully!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void moveFile(String sourcePath, String destinationPath) {
        try {
            Path source = Paths.get(sourcePath);
            Path destination = Paths.get(destinationPath);
            Files.move(source, destination, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File moved successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String extractFileName(String filePath) {
        File file = new File(filePath);
        String fileName = file.getName();
        return fileName;
    }

}
