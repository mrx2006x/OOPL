// File Name: Ecommerce.java

import java.util.Scanner;

class Product {

    int productId;
    String productName;
    double price;
    int quantity;
    double total;

    // Default Constructor
    Product() {
        productId = 101;
        productName = "Mouse";
        price = 500;
        quantity = 1;
        total = price * quantity;
    }

    // Parameterized Constructor
    Product(int id, String name, double p, int q) {
        productId = id;
        productName = name;
        price = p;
        quantity = q;
        total = price * quantity;
    }
}

public class Ecommerce {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Product products[] = new Product[10];

        int count = 0;
        char choice;

        double grandTotal = 0;
        double discount = 0;

        System.out.println("===== E-COMMERCE ORDER PROCESSING =====");

        // Default Product
        products[count] = new Product();
        count++;

        do {

            System.out.println("\nEnter Product Details");

            System.out.print("Enter Product ID: ");
            int id = sc.nextInt();

            sc.nextLine();

            System.out.print("Enter Product Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Product Price: ");
            double price = sc.nextDouble();

            System.out.print("Enter Quantity: ");
            int quantity = sc.nextInt();

            // Parameterized Constructor
            products[count] = new Product(id, name, price, quantity);

            count++;

            System.out.print("\nDo you want to add more products? (y/n): ");
            choice = sc.next().charAt(0);

        } while(choice == 'y' || choice == 'Y');

        // Final Invoice
        System.out.println("\n========== FINAL INVOICE ==========");

        System.out.println("ID\tName\t\tPrice\tQuantity\tTotal");

        for(int i = 0; i < count; i++) {

            System.out.println(
                products[i].productId + "\t" +
                products[i].productName + "\t\t" +
                products[i].price + "\t" +
                products[i].quantity + "\t\t" +
                products[i].total
            );

            grandTotal += products[i].total;
        }

        // Discount Policy
        if(grandTotal > 5000) {
            discount = grandTotal * 0.10;
        }

        double finalAmount = grandTotal - discount;

        System.out.println("\n====================================");
        System.out.println("\nGrand Total: " + grandTotal);
        System.out.println("Discount: " + discount);
        System.out.println("Final Amount: " + finalAmount);

        sc.close();
    }
}