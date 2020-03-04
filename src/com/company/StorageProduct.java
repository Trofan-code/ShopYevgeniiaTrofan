package com.company;

import java.util.ArrayList;

/**
 * Created by User on 25.11.2019.
 */
public class StorageProduct {
 ArrayList <Product> list;

 StorageProduct(){
  list= new ArrayList<Product>();
  list.add(new Product("Kubek",2,5));
  list.add(new Product("Talerz",5,10));
  list.add(new Product("Szklanka",3,15));
 }

 void addProduct (Product product){
  list.add(product);
  System.out.println( "Towar zostal dodany");
 }

 void removeProduct(String productName,float productPrice,int productCount){
  for( Product product : list){
   if (product.productName.equals(productName)&&product.productPrice == productPrice){
    product.productCount=product.productCount-productCount;
    System.out.println("Towar zostal usuniety.");
   }
  }
 }

 void removeProduct(Basket basket){
 for (Product productInBasket:basket.productsInBasket){
  for(Product productInStorage:list){
   if(productInBasket.productName==productInStorage.productName && productInBasket.productPrice==productInStorage.productPrice ){
    productInStorage.productCount= productInStorage.productCount - productInBasket.productCount;
    }
    }
 }
 }

Product findProduct(String productNameFromUser){
 for (Product product: list ) {
  if(product.productName.equals(productNameFromUser)){
   return product;
  }
 }
 System.out.println("Nie ma takiego towaru!");
 return null;
}

void storageShow(){
 for (Product product : list ) {
  System.out.println("Nazwa towaru: " + product.productName + " | Cena towaru: " + product.productPrice +
          " zl. | Ilosc towaru : " + product.productCount + " szt. ");
 }
 System.out.println();
}
}
