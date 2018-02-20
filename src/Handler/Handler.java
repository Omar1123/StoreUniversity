/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Handler;

import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
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
    private int option;
    
    //File import
    
    private FileOutputStream fileStream;    
    private File FILENAME = new File("/Users/jake/NetBeansProjects/StoreUniversity/src/STORE.txt");
    private DataOutputStream data;    
    
    public Handler() {
        clientName = "";
        ProductName = "";
        price = 0.0;
        amount = 0;
        dateTime = "";
        option = 0;
    }
    
    public void doPurchase() {
        
        createStoreFile(FILENAME);
        
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
        
        createStorePurchase(FILENAME, clientName, ProductName, price, amount, dateTime);
        
        doOtherPurchase();
    }
    
    private String getDateTime() {
         DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
         Date today = Calendar.getInstance().getTime();        
         String purcharseDate = df.format(today);
         return purcharseDate;
    }
   
    private void createStorePurchase(File file, String clientNameFile, String productNameFile, 
            double priceFile, int amountFile, String dateTimeFile) {        
        try {
          
            if(!file.exists()){  
                file.createNewFile();
            }
            
            BufferedWriter writter =new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file,true), "utf-8"));
            
            writter.write(clientNameFile + "," + productNameFile + "," + priceFile + "," + amountFile + "," + dateTimeFile + "\r\n");
          
            writter.close();
            
            System.out.println("Se ha realizado con exito su compra");
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }      
    }
    
    private void createStoreFile(File file) {
        
        System.out.println("Creando el documento con los datos");
        
        try {          
            if(!file.exists()){
                file.createNewFile();
            }          
        } catch (Exception ex) {            
            System.out.println(ex.getMessage());
        } 
    }
    
    private void doOtherPurchase() {
        
        Scanner scannerDecitionPurchase = new Scanner(System.in);
        System.out.println("Desea ingresar otra compra(1:SI/2:NO)");
        option = scannerDecitionPurchase.nextInt();
        
        if(option == 1) {
            doPurchase();
        } else {
            System.out.println("Gracias por realizar su compra");    
        }             
    }
}
