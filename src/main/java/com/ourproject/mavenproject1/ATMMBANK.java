package com.ourproject.mavenproject1;
import java.sql.*;
import java.util.Scanner;

public class ATMMBANK {
    
    public static void main(String[] args) throws Exception {
        UserBankAccount user = new        UserBankAccount(2222,22);
        UserBankAccount Abdullah = new    UserBankAccount(3333,33);
        UserBankAccount Abdulrahman = new UserBankAccount(4444,44);
        UserBankAccount khalid = new      UserBankAccount(5555,55);
        getConnection();
        
        Scanner reader = new Scanner (System.in);
        
        System.out.println("1.Create an admin account ");
        System.out.println("2.Already have a user account");
        int enter = reader.nextInt();
        
        switch(enter){
            case 1:
                System.out.println("Enter Admin ID");
                int adid= reader.nextInt();
                System.out.println("Enter Admin Pin");
                int adpin= reader.nextInt();
                AdminBankAccount Admin = new AdminBankAccount(adid,adpin);
                getConnection1(adid ,adpin);
                break;
            case 2:

                break;
        }
        
        int option ;
        System.out.println("1.Balance");
        System.out.println("2.deposit");
        System.out.println("3.withdraw");
        System.out.println("4.Transfer");
        System.out.println("5.Previous Transaction");
        System.out.println("6.Exit");
            
        do{
           System.out.println("==== Enter an option ====");
               
             option = reader.nextInt();
            System.out.println("\n");
               
               
               switch(option){
                   case 1:
                       
                       System.out.println("==================== ");
                       System.out.println("Balance = "+ user.getBalance());
                       System.out.println("==================== ");
                       System.out.println("\n");
                       break;
                       
                       
                   case 2:
                       System.out.println("==================== ");
                       System.out.println("Enter an amount to deposit");
                       System.out.println("==================== ");
                       double amount = reader.nextDouble();
                       user.deposit(amount);
                       double PreviousTransaction1 = amount;
                       System.out.println("\n");
                       break;
                       
                       
                   case 3:
                       System.out.println("==================== ");
                       System.out.println(" Enter an amount to withdraw ");
                       System.out.println("==================== ");
                       double amount2 = reader.nextDouble();
                       user.withdraw(amount2);
                       double PreviousTransaction2 = amount2 ;
                      
                       System.out.println("\n");
                       break;
                  
                      case 5:
                       System.out.println("==================== ");
                       user.getHistoryTransaction1();
                       System.out.println("==================== ");
                       break;
                        case 4:
                       System.out.println("==================== ");
                       System.out.println(" choose an account to transfer to  ");
                       System.out.println("==================== ");
                    int press;
                       System.out.println("==================== ");
                       System.out.println("1.Abdullah's Account");
                       System.out.println("==================== ");
                       System.out.println("2. Abdulrahman's Account");
                       System.out.println("==================== ");
                       System.out.println("3. khalid's Account");
                       System.out.println("==================== ");
                       
                       press = reader.nextInt();
                    switch(press){
                        
                        
                        case 1:
                            System.out.println("Enter an amount to Transfer");
                            double amount1=reader.nextDouble();
                            user.transfer(amount1, Abdullah);
                            double PreviousTransaction3 = amount1;
                            
                        break;
                        case 2:
                            System.out.println("Enter an amount to Transfer");
                            double amount3=reader.nextDouble();
                            user.transfer(amount3, Abdulrahman);
                             PreviousTransaction3 = amount3;
                             
                        break;
                        case 3:
                            System.out.println("Enter an amount to Transfer");
                            double amount4=reader.nextDouble();
                            user.transfer(amount4, khalid);
                            PreviousTransaction3 = amount4;
                           
                            break;
                    }
                      case 6:
                       System.out.println("******************** ");
                       break;
                       
                       
                   default:
                       System.out.println("Invalid Option !! please enter again");
                       break;
               }
        }while(option !=6);
           System.out.println("Thank you for using our services");
    
        //141
    }
    public static Connection getConnection() throws Exception{
        Connection con = null;
        java.sql.Statement stmt = null;
        PreparedStatement ps= null;
        ResultSet rs = null;
        try{
            String driver = "com.mysql.cj.jdbc.Driver";
            String username="root";
            String password= "102030";
            Class.forName(driver);
             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Banking?zeroDateTimeBehavior=CONVERT_TO_NULL",username,password); 
            System.out.println("Connected");
            return con;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public static void getConnection1(int adid, int adpin) throws Exception{
        final int a = adid;
        final int b = adpin;
        try{
           Connection con1 = getConnection();
           PreparedStatement ps1 =con1.prepareStatement("INSERT INTO AdminBankAccount(AdminID,AdminPin)VALUES ("+adid+","+adpin+")");//VALUES ('"+Text1+"','"+Text2+"')";
           ps1.executeUpdate();
       }catch(Exception e){System.out.println(e);}
        finally{System.out.println("Founction complete.");}
    }
    public static void getConnection2()throws Exception{
        Scanner reader = new Scanner (System.in);
        System.out.println("Enter The account id that you want to delete it ");
           
        final int c = reader.nextInt();
        try{
             Connection con2 = getConnection();
           PreparedStatement ps2 =con2.prepareStatement("Delete from UserCard where UserAccountID= "+c);//"delete from  DeleteTableDemo " + "where id=101";
           ps2.executeUpdate();
       }catch(Exception e){System.out.println(e);}
        finally{System.out.println("Account has been deleted");}
        }
    public static void  getConnection3()throws Exception{
        try{
            Connection con3 = getConnection();
            PreparedStatement ps3 = con3.prepareStatement("Select UserAccountID ,UserAccountPin from UserCard");
            ResultSet rs3 = ps3.executeQuery();
            
            while(rs3.next()){
                System.out.print(rs3.getInt("UserAccountID"));
                System.out.print(" , ");
                System.out.println(rs3.getInt("UserAccountPin"));
               
            }
            System.out.println("All records have been selected");
           
        }catch(Exception e){System.out.println(e);}
        
    }    
    public static double  getConnection5(double Balance)throws Exception{
            double money = 0;
        try{
            Connection con5 = getConnection();
            PreparedStatement ps5 = con5.prepareStatement("update UserCard set balance ="+Balance+" where UserAccountID =2222;");
            ps5.executeUpdate();
            
            
        }catch(Exception e){System.out.println(e);}
        return money;
    } 


    public static void getConnection6(double amount)throws Exception{
        final double money3 = amount;
        try{
            Connection con6 = getConnection();
                                                        
            PreparedStatement ps6 =con6.prepareStatement("insert into TransactionHistory (UserAccountID,TransactionID,deposit) values (2222,null,"+money3+")");
            ps6.executeUpdate();
            
            }catch(Exception e){System.out.println(e);}
            finally{System.out.println("Founction complete.");}
    }    
    public static void getConnection7(double amount)throws Exception{
        final double money4 = amount;
        try{
            Connection con7 = getConnection();
                                                        
            PreparedStatement ps7 =con7.prepareStatement("insert into TransactionHistory (UserAccountID,TransactionID,withdraw) values (2222,null,"+money4+")");
            ps7.executeUpdate();
            
            }catch(Exception e){System.out.println(e);}
            finally{System.out.println("Founction complete.");}
    }
    public static void getConnection8(double amount)throws Exception{
        final double money5 = amount;
        try{
            Connection con8 = getConnection();
            
            PreparedStatement ps8 =con8.prepareStatement("insert into TransactionHistory (UserAccountID,TransactionID,transfer) values (2222,null,"+money5+")");
            ps8.executeUpdate();
            
            }catch(Exception e){System.out.println(e);}
            finally{System.out.println("Founction complete.");}
    }

       public static void getConnection11(int adid, int adpin) throws Exception{
        final int a = adid;
        final int b = adpin; 
        try{
           Connection con1 = getConnection();
           PreparedStatement ps1 =con1.prepareStatement("INSERT INTO UserCard(UserAccountID,UserAccountPin)VALUES ("+adid+","+adpin+")");//VALUES ('"+Text1+"','"+Text2+"')";
           ps1.executeUpdate();
       }catch(Exception e){System.out.println(e);}
        finally{System.out.println("Account Has been created.");}
    }
         public static void  getConnection9()throws Exception{
        try{
            Connection con9 = getConnection();
            PreparedStatement ps9 = con9.prepareStatement("Select * from TransactionHistory");
            ResultSet rs9 = ps9.executeQuery();
            
            while(rs9.next()){
                
                System.out.print(rs9.getInt("UserAccountID"));
                System.out.print(" : deposit : ");
                System.out.println(rs9.getInt("deposit"));
                System.out.print(rs9.getInt("UserAccountID"));
                System.out.print(" : withdraw : ");
                System.out.println(rs9.getInt("withdraw"));
                System.out.print(rs9.getInt("UserAccountID"));
                System.out.print(" : transfer : ");
                System.out.println(rs9.getInt("transfer"));
                
               
            }
            System.out.println("This all your Transaction History");
           
        }catch(Exception e){System.out.println(e);}
        
    }
    
}
