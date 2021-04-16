package com.ourproject.mavenproject1;

import static com.ourproject.mavenproject1.ATMMBANK.getConnection11;
import static com.ourproject.mavenproject1.ATMMBANK.getConnection2;
import static com.ourproject.mavenproject1.ATMMBANK.getConnection3;
import java.util.Scanner;
public class AdminBankAccount {
        Scanner reader = new Scanner(System.in);
       private static int AdminID;
       private static int AdminPin;
       
       AdminBankAccount(int ID , int pinn) throws Exception{
            AdminID=ID;
            AdminPin=pinn;
            
            System.out.println("Please enter your Pin code again "); 
            int Admincode = reader.nextInt();
          

           if(Admincode !=AdminPin){
              System.out.println("Incorrect Pin");
              do{
                  System.out.println("Enter Your pin code again");
                   Admincode = reader.nextInt();
                   
          }while(Admincode !=AdminPin);
              
               if(Admincode == AdminPin){
              System.out.println("Correct Pin");
              int enter='\0';
                       System.out.println("1.Delete a sepesific account");
                       System.out.println("2.show all accounts");
                       System.out.println("3. to create user Account ");
                       System.out.println("4. to exit ");
                     do{  
                         System.out.println("Enter an option");
                       enter =reader.nextInt();
                   switch(enter){
                       case 1:
                           deleteAccount() ;
                           break;
                       case 2:
                             showAllAccounts();
                           break;
                       case 3 :
                            System.out.println("Enter User Account ID");
                            int adid= reader.nextInt();
                            System.out.println("Enter User Account Pin");
                            int adpin= reader.nextInt();
                            UserBankAccount User5 = new UserBankAccount(5555,55);
                            getConnection11(adid ,adpin);
                           break;
                       case 4 :
                           break;
                   }
                   }while(enter != 4);
            }  
              
       }
       }
       
       void deleteAccount() throws Exception {
        System.out.println("Hi "+AdminID+" you are going to delet a sepesific account");
        getConnection2();
    }
     void showAllAccounts() throws Exception{
         System.out.println(AdminID+" be patient we are going to show you all accounts");
         getConnection3();
     }
}
