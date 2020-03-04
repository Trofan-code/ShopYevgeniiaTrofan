package com.company;

import java.io.*;

/**
 * Created by User on 01.12.2019.
 */
public class User {
    private String adminLogin;
    private String adminPassword;
    Basket basket;
    User(){
      basket = new Basket();
    }
    String temp="";
    InputStream inputStream = System.in;
    Reader inputStreamReader = new InputStreamReader(inputStream);
    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
    String findProduct ()throws IOException{
        System.out.println("Podaj nazwę towaru: ");
        String productName = bufferedReader.readLine();
        return productName;
    }

    void addToBasket(String productName,float productPrice)throws IOException{
        System.out.println("Podaj ilosc towaru: ");
        temp = bufferedReader.readLine();
        int countNumberOfProduct = Integer.parseInt(temp);

        Product productForBuyByUser = new Product(productName,productPrice,countNumberOfProduct);
        basket.productsInBasket.add(productForBuyByUser);
    }

    Basket buy () throws IOException {
        float totalSum = 0;
        float sum = 0;
        System.out.println("Podsumowanie zakupu: ");
        for (Product product : basket.productsInBasket ) {
            sum = product.productPrice*product.productCount;
            System.out.println("Nazwa towaru: " + product.productName + " | Cena towaru: " + product.productPrice +
                    " zl. | Ilosc towaru : " + product.productCount + " szt. Suma:  " + sum + " zl.");
            totalSum = sum+totalSum;
        }
        System.out.println("Koszt calkowity zakupu: " + totalSum +" zl.");
        System.out.println("Kupuje i place. 1- Tak / 2 - Nie");
        temp = bufferedReader.readLine();
        int actionNumberForPay = Integer.parseInt(temp);
        if(actionNumberForPay==1){
            System.out.println("Zamówienie zrealizowane, Dziękujemy za zakupy!");
            return basket;
        }
        return null;
    }
}
