drop database Banking;
create database Banking;
use banking;
create table AdminBankAccount(
AdminID int  primary key,
AdminPin int unique,
DateRegister TIMESTAMP default CURRENT_TIMESTAMP
);
desc AdminBankAccount;
create table UserCard(
UserAccountID int primary key,
UserAccountPin int ,
Balance float,
DateRegister TIMESTAMP default CURRENT_TIMESTAMP
);
desc UserCard;
select * from UserCard;
create table TransactionHistory(
UserAccountID int default 2222,
TransactionID int primary key auto_increment,
deposit float,
withdraw float,
transfer float,
TransactionTime TIMESTAMP default CURRENT_TIMESTAMP
);
desc TransactionHistory;
Select * from TransactionHistory;


