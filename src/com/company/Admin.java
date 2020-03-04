package com.company;

import java.io.*;

/**
 * Created by User on 25.11.2019.
 */
public class Admin {
 private String adminLogin;
 private String adminPassword;
 String temp="";
 InputStream inputStream = System.in;
 Reader inputStreamReader = new InputStreamReader(inputStream);
 BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

 void addProduct  (StorageProduct storageProduct) throws IOException {
  System.out.println("Podaj nazwę towaru: ");
  String productName = bufferedReader.readLine();
  System.out.println("Podaj cene towaru: ");
  temp = bufferedReader.readLine();
  float productPrice = Float.parseFloat(temp);
  System.out.println("Podaj ilosc towaru: ");
  temp = bufferedReader.readLine();
  int productCount = Integer.parseInt(temp);
  Product product = new Product(productName,productPrice,productCount);
  storageProduct.addProduct(product);
 }

 void removeProduct (StorageProduct storageProduct) throws IOException{
  System.out.println("Podaj nazwę towaru: ");
  String productName = bufferedReader.readLine();
  System.out.println("Podaj cene towaru: ");
  temp = bufferedReader.readLine();
  float productPrice = Float.parseFloat(temp);
  System.out.println("Podaj ilosc towaru do usuniencia: ");
  temp = bufferedReader.readLine();
  int productCount = Integer.parseInt(temp);
  storageProduct.removeProduct(productName,productPrice,productCount);
 }
}
