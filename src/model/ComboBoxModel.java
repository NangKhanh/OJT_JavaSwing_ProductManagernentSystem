/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author hp
 */
public class ComboBoxModel {
    Object value;
    Object text;

    public ComboBoxModel(Object value, Object text) {
        this.value = value;
        this.text = text;
    }

    @Override
    public String toString() {
        return text.toString();
    }
    
    public int MaInt(){
        return Integer.parseInt(value.toString());
    }
    
    public String MaString(){
        return  value.toString();
    }
}
