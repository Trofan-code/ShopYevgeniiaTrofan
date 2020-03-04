package com.company;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import com.sun.org.apache.xpath.internal.operations.Bool;
import java.awt.event.MouseEvent;
import java.io.*;
public class Shop {
    public static void main(String[] args) throws IOException {
        String temp = "";
        Boolean run = true;
        StorageProduct storageProduct = new StorageProduct();
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        while (run) {
            System.out.print("Wprozadź swoja role (admin/user): ");
            String role = bufferedReader.readLine();
            if (role.equals("admin")) {
                Admin admin = new Admin();
                int lastAction = 0;
                System.out.println("Witaj, admin! ");
                while (lastAction != 9) {
                    System.out.println("Wybierź opcje: \n1 - Dodaj towar. \n2 - Usuń towar. \n3 - Pokaz magazyn. \n9 - Wyjdz na strone logowania.");
                    temp = bufferedReader.readLine();
                    int actionNumber = Integer.parseInt(temp);
                    if (actionNumber == 1) {
                        admin.addProduct(storageProduct);
                    } else if (actionNumber == 2) {
                        admin.removeProduct(storageProduct);
                    }
                    else if (actionNumber == 3){
                        storageProduct.storageShow();
                    }
                    else if (actionNumber == 9) {
                    } else {
                        System.out.println("Nie prawidłowo wprowadzona opcja!!!");
                    }
                    lastAction = actionNumber;
                }
            }
//////wyszukanie i wybór z listy towarów wmagazynie, dodanie do koszyka, zapłata
            if (role.equals("user")) {
                User user = new User();
                int lastAction = 0;
                System.out.println("Witaj, user! ");
                while (lastAction != 9) {
                    System.out.println("Wybierź opcje: \n1 - Wyszukaj towar. \n2 - Pokaz magazyn. \n9 - Wyjscie na strone logowanie");
                    temp = bufferedReader.readLine();
                    int actionNumber = Integer.parseInt(temp);
                    if (actionNumber == 1) {
                        temp = user.findProduct();
                        Product tempProduct = storageProduct.findProduct(temp);
                        if (tempProduct!=null) {
                            System.out.println("Nazwa towaru: " + tempProduct.productName + " | Cena towaru: " + tempProduct.productPrice + " zl | Ilosc towaru na magazynie: " + tempProduct.productCount + " szt.");
                            System.out.println("Dodac ten towar do koszyka??? 1 - Tak / 2 - Nie");
                            temp = bufferedReader.readLine();
                            int choiseNumber = Integer.parseInt(temp);
                            if (choiseNumber == 1) {
                                user.addToBasket(tempProduct.productName, tempProduct.productPrice);
                                System.out.println("Kontynujemy zakupy??? 1 - Tak / 2 - Nie, idz do oplaty zakupu. ");
                                temp = bufferedReader.readLine();
                                int actionNumberForBuy = Integer.parseInt(temp);
                                if (actionNumberForBuy == 2) {
                                    Basket basketForBuyByUser = user.buy();
                                    if (basketForBuyByUser != null) {
                                        storageProduct.removeProduct(basketForBuyByUser);
                                    }
                                }
                            }
                        }
                    }
                    else if (actionNumber == 2){
                        storageProduct.storageShow();
                    }
                    else if (actionNumber == 9) {
                    } else {
                        System.out.println("Nie prawidłowo wprowadzona opcja!!!");
                    }
                    lastAction = actionNumber;
                }
            }
            if (!role.equals("admin") && !role.equals("user")) run=false;
        }
    }
}