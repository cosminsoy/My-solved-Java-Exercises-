/* 
(The Account class) Design a class named Account that contains:

■■ A private int data field named id for the account (default 0).
■■ A private double data field named balance for the account (default 0).
■■ A private double data field named annualInterestRate that stores the current interest rate (default 0). Assume that all accounts have the same interest rate.
■■ A private Date data field named dateCreated that stores the date when the account was created.
■■ A no-arg constructor that creates a default account.
■■ A constructor that creates an account with the specified id and initial balance.
■■ The accessor and mutator methods for id, balance, and annualInterestRate.
■■ The accessor method for dateCreated.
■■ A method named getMonthlyInterestRate() that returns the monthly interest rate.
■■ A method named getMonthlyInterest() that returns the monthly interest.
■■ A method named withdraw that withdraws a specified amount from the account.
■■ A method named deposit that deposits a specified amount to the account.

Draw the UML diagram for the class then implement the class. (Hint: The method getMonthlyInterest() is to return monthly interest, not the interest rate.
Monthly interest is balance * monthlyInterestRate. monthlyInterestRate is annualInterestRate / 12. Note annualInterestRate is a percentage, for example 4.5%. You need to divide it by 100.)

Write a test program that creates an Account object with an account ID of 1122, a balance of $20,000, and an annual interest rate of 4.5%. Use the withdraw method to withdraw $2,500, use the deposit method to deposit $3,000, and print the balance, the monthly interest, and the date when this account was created.
*/

import java.util.*;   
import java.time.*;

class Main {
  public static void main(String[] args) {

    //object with an account ID of 1122, a balance of $20,000
    Account newAcc1 = new Account(1122, 20000);

    //annual interest rate of 4.5%
    newAcc1.setAnnualInterestRate(4.5);

    //Use the withdraw method to withdraw $2,500
    newAcc1.withdraw(2500);

    //use the deposit method to deposit $3,000
    newAcc1.deposit(3000);

    //print the balance, the monthly interest, and the date when this account was created.
    System.out.printf("Balance: $%.2f\nMonthly interest: $%.2f\nDate when this account was created: %s", newAcc1.getBalance(), newAcc1.getMonthlyInterest(), newAcc1.getDateCreated() );

  }
}



class Account {

	private int id = 0;
	private double balance = 0;
	private double annualInterestRate = 0;
	private String accDate; 

	//A no-arg constructor that creates a default account.
	Account(){
 
		accDate = LocalDate.now().toString();
	}

	//A constructor that creates an account with the specified id and initial balance.
	Account(int id, double balance){

		accDate = LocalDate.now().toString();
		this.id = id;
		this.balance = balance;		
	}

	//Below accessor and mutator methods for id, balance, and annualInterestRate.
	public void setId() {

		this.id = id;
	}

	public void setBalance() {

		this.balance = balance;
	}

	public void setAnnualInterestRate(double annualInterestRate) {

		this.annualInterestRate = annualInterestRate;
	}

	public int getId() {

		return id;
	}

	public double getBalance() {

		return  balance;
	}

	public double getAnnualInterestRate() {

		return annualInterestRate;
	}

	//accessor method for dateCreated.
	public String getDateCreated() { 
  
    return accDate;
	}

	//returns the monthly interest.
	public double getMonthlyInterestRate() {

		return (annualInterestRate / 100) / 12;
	}

  //returns the monthly interest.
  public double getMonthlyInterest() {

		return balance * getMonthlyInterestRate();
	}
	
  public void withdraw(double amount) {

    if(this.balance - amount > 0)
		  this.balance -= amount;
    else
      System.out.println("Not enough funds to complete transaction.");
	}

  public void deposit(double amount) {

		this.balance += amount;
	}
	
}
