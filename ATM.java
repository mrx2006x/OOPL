// File Name: ATM.java

import java.util.Scanner;

public class ATM {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double balance = 10000;

        int choice;

        do {

            System.out.println("\n===== ATM MACHINE =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            try {

                switch(choice) {

                    case 1:

                        System.out.println("Current Balance: " + balance);
                        break;

                    case 2:

                        System.out.print("Enter Deposit Amount: ");
                        double deposit = sc.nextDouble();

                        if(deposit <= 0) {
                            throw new IllegalArgumentException("Invalid Deposit Amount.");
                        }

                        balance = balance + deposit;

                        System.out.println("Money Deposited Successfully.");
                        System.out.println("Updated Balance: " + balance);

                        break;

                    case 3:

                        System.out.print("Enter Withdrawal Amount: ");
                        double withdraw = sc.nextDouble();

                        if(withdraw > balance) {
                            throw new ArithmeticException("Insufficient Balance.");
                        }

                        if(withdraw <= 0) {
                            throw new IllegalArgumentException("Invalid Withdrawal Amount.");
                        }

                        balance = balance - withdraw;

                        System.out.println("Money Withdrawn Successfully.");
                        System.out.println("Updated Balance: " + balance);

                        break;

                    case 4:

                        System.out.println("Thank You for Using ATM.");
                        break;

                    default:

                        System.out.println("Invalid Choice!");
                }

            }

            catch(ArithmeticException e) {

                System.out.println("Exception: " + e.getMessage());
            }

            catch(IllegalArgumentException e) {

                System.out.println("Exception: " + e.getMessage());
            }

            catch(Exception e) {

                System.out.println("Invalid Input!");
                sc.nextLine();
            }

            finally {

                System.out.println("Transaction Completed.");
            }

        } while(choice != 4);

        sc.close();
    }
}