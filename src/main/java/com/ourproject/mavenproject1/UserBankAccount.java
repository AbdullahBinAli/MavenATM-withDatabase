package com.ourproject.mavenproject1;


import static com.ourproject.mavenproject1.ATMMBANK.getConnection5;
import static com.ourproject.mavenproject1.ATMMBANK.getConnection6;
import static com.ourproject.mavenproject1.ATMMBANK.getConnection7;
import static com.ourproject.mavenproject1.ATMMBANK.getConnection8;
import static com.ourproject.mavenproject1.ATMMBANK.getConnection9;
import java.util.Scanner;
public class UserBankAccount {
    Scanner reader= new Scanner (System.in);
    private double balance;
    double PreviousTransaction1;
    double PreviousTransaction2;
    double PreviousTransaction3;
    
    private long UserAccountID;
    private int UserAccountPin;
 
    UserBankAccount(long ID ,int pin){
        this.UserAccountPin= pin;
        this.UserAccountID = ID ;

    }
    double getBalance() throws Exception{
        
        balance =this.balance;
        
        getConnection5(balance);
        return balance;
    }
    
    void deposit(double amount) throws Exception{
        System.out.println("old balance = " + balance);
        balance =balance +amount;
        PreviousTransaction1=amount;
        System.out.println("new balance = " +balance);
        getConnection6(PreviousTransaction1);
    }
    void withdraw(double amount) throws Exception{
        if (amount <=balance){
            System.out.println("old balance = " + balance );
            balance = balance - amount ; // balance - amount = balance
            PreviousTransaction2 = amount;
            System.out.println("new balance = " + balance );
            getConnection7(PreviousTransaction2);
        }
        else{
            System.out.println("withdrawal fails  "); // the amount is > than balance 
        }
    }
         void transfer(double amount , UserBankAccount acc) throws Exception{
            if (this.balance < amount){
                System.out.println("Transfer fails");
            }
            else {
                this.balance -= amount;
                
                acc.balance+=amount;
                PreviousTransaction3 = amount;
                 System.out.println("This Account ID " + this.UserAccountID + " transferes " + amount +" to this account ID "+ acc.UserAccountID);
                getConnection8(PreviousTransaction3);
            }
        }
         void getHistoryTransaction1() throws Exception{

            getConnection9();
         } 
}
