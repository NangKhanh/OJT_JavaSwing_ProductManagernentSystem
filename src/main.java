/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
import controller.Controller;
import view.ProductView;
import view.StockView;

/**
 *
 * @author hp
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ProductView productView = new ProductView();
        Controller controller = new Controller(productView);
        controller.startProgram();
    }

}
