package main;

/**
 * Taken from CISC181 Repository Week 3 > Package 4 > InsufficientFundsException
 * 
 * InsufficientFundsException class that extends Exception class
 * Executes if a used attempts to withdraw more than their balance
 * 
 */
public class InsufficientFundsException extends Exception{

	private double amount;
	
	public InsufficientFundsException(double amount){
		this.amount = amount;
		System.out.printf("I'm sorry, you need $%3.2f more in your account to withdraw that amount.\n", amount);
	}
	
	public double getAmount(){
		return this.amount;
	}

}
