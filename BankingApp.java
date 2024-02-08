/**
 * This is a simple banking system application that allows users to perform various banking operations, such as opening accounts, depositing money & withdrawing money, and viewing account details.
 * @author Bunhout Nub
 * @version 0.1 (Feb 8, 2024);
 */

import java.util.Scanner;
// Class representing bank account details
class BankDetails{
  private String accNo;
  private String accType;
  private String accName;
  private double balance;
  
  Scanner scanner = new Scanner(System.in);
  //method to open a new account
  public void openAccount(){
    System.out.print("Enter account number: ");
    accNo = scanner.next();
    System.out.print("Enter account type: ");
    accType = scanner.next();
    System.out.print("Enter your name: ");
    accName = scanner.next();
    System.out.print("Enter balance: ");
    balance = scanner.nextDouble();
  }
  //method to show account details
  public void showAccount(){
    System.out.println("\nName of the account holder: "+ accName);
    System.out.println("Account number: "+accNo);
    System.out.println("Account type: "+accType);
    System.out.println("Balance: $"+balance);
  }

  //method to search for an account by account number
  public boolean search(String no){
    if (accNo.equals(no)){
      showAccount();
      return (true);
    } else {
      return(false);
    }
  }
  //method to deposit money
  public void deposit(){
    System.out.print("\nEnter the amout you want to deposit: ");
    double amount = scanner.nextDouble();
    System.out.print("Deposited $"+amount+"\n");
    balance = balance + amount;
  }

  //method to wtihdrawal money
  public void withdrawal(){
    System.out.print("\nEnter the amount you want to withdraw: ");
    double amount = scanner.nextDouble();
    if (balance < amount){
      System.out.println("\nYou balance is less than "+amount+". Transaction failed..!");
    } else {
      System.out.print("Withdrew $"+amount+"\n");
      balance = balance - amount;
    }
  }

}
//main class for running the banking application
public class BankingApp{
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    System.out.print("How many accounts do you want to open: ");
    int customer = scanner.nextInt();
    //create an array of BankDetails with objects named 'Cus', and the size of the array depands on the the values stored in customer.
    BankDetails Cus[] = new BankDetails[customer]; 
    for (int i = 0; i < Cus.length; i++){
      Cus[i] =  new BankDetails(); 
      Cus[i].openAccount();
    }
    
    int ch;
    //main loop
    do {
      System.out.println("\n***Banking System Application***\n");
      System.out.println("1. Display all account details \n2. Search account number \n3. Disposit\n4. Withdrawal\n5. Exit");
      System.out.print("\nEnter your choice: ");
      ch = scanner.nextInt();
        switch (ch){
          //display all account details
          case 1: 
            for (int i = 0; i < Cus.length; i++){
              Cus[i].showAccount();
            }
            break;
            //search for an account number
          case 2 : 
            System.out.print("\nEnter account no. you want to search: ");
            String ac_no = scanner.next();
            boolean found = false;
            for (int i = 0; i < Cus.length; i++ ){
              found = Cus[i].search(ac_no);
              if (found){
                break;
              }
            }
              if (!found){
                System.out.print("Search failed. Account doesn't exist..! ");
              }
              break;
              //deposit into an account
              case 3: 
                System.out.print("Enter Account Number: ");
                ac_no = scanner.next();
                found = false;
                for (int i = 0; i < Cus.length; i++){
                  found = Cus[i].search(ac_no);
                  if (found){
                    Cus[i].deposit();
                    break;
                  } 
                }
                  if (!found ){
                  System.out.print("\nSearch failed! Account doesn't exist..!\n");
                }
                break;
              //withdraw money from an account
              case 4:
                System.out.print("Enter Account Number: ");
                ac_no = scanner.next();
                found = false;
                for (int i = 0; i< Cus.length; i++){
                  found = Cus[i].search(ac_no);
                  if (found){
                    Cus[i].withdrawal();
                  }
                  break;
                }
                if (!found){
                  System.out.print("\nSearch failed! Account doesn't exist..!\n");
                }
                break;
              //exit the program
              case 5: 
                System.out.print("Have a nice day!");
                break;
            }
            //continue looping until the use choose to exit
          } while (ch != 5 );
          scanner.close();
        }
  }