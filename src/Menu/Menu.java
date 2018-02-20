/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import java.util.Scanner;

/**
 *
 * @author jake
 */
public class Menu {
    
    private int option;
    
    public Menu() {
        option = 0;
    }
    
    public void showOptions() {
        
        Scanner scannerOption = new Scanner(System.in);
       
        System.out.println("Usuario");
        System.out.println("1) Realizar compra");
        System.out.println("2) Consultar saldo");
        System.out.println("Administrador");
        System.out.println("3) Corte de caja");
        
        option = scannerOption.nextInt();
    }
    
    public void chooseHandler(int option) {
        
        if(option == 1) {
            
        }
        
        if(option == 2) {
            
        }
        
        if(option == 3) {
            
        }
    }
    
    
    
}
