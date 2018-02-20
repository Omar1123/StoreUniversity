/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Handler;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author jake
 */
public class Handler {
    
    private String clientName;
    private String ProductName;
    private double price;
    private int amount;
    private String dateTime;
    
    public Handler() {
        clientName = "";
        ProductName = "";
        price = 0.0;
        amount = 0;
        dateTime = "";
    }
    
    public void doPurchase() {
        
        Scanner scannerPurchase = new Scanner(System.in);
        
        System.out.println("Ingrese el nombre del cliente");
        clientName = scannerPurchase.next();
        
        System.out.println("Ingrese el nombre del producto");
        ProductName = scannerPurchase.next();
        
        System.out.println("Ingrese el precio del producto");
        price = scannerPurchase.nextDouble();
        
        System.out.println("Ingrese la cantidad de producto a llevar");
        amount = scannerPurchase.nextInt();
       
    
        dateTime = getDateTime();
   }
    
   private String getDateTime() {
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Date today = Calendar.getInstance().getTime();        
        String purcharseDate = df.format(today);
        return purcharseDate;
   }
    
}
