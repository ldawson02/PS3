package main;

import java.util.Date;

public class Account {

	private int id;
	private double balance;
	private double annualInterestRate; // in decimal form
	private Date dateCreated;

	// No args constructor
	public Account() {

	}

	// Constructor with args id and balance
	public Account(int id, double balance) {
		this.id = id;
		this.balance = balance;
		this.dateCreated = new Date();
	}

	// Getter and setter for attribute id
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	// Getter and setter for attribute balance
	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	// getter and setter for attribute annualInterestRate
	public double getAnnualInterestRate() {
		return annualInterestRate;
	}

	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}

	// Getter for attribute dateCreated
	public Date getDateCreated() {
		return dateCreated;
	}

	// Method that returns the monthly interest rate
	public double getMonthlyInterestRate() {
		return (this.annualInterestRate / 12);
	}

	// Method that withdraws input amount from balance
	public void withdraw(double amount) throws InsufficientFundsException {
		if (balance >= amount) {
			this.setBalance(balance - amount);
		} 
		else {
			throw new InsufficientFundsException(amount - balance);
		}

	}

	// Method that adds input amount to balance
	public void deposit(double amount) {
		this.setBalance(balance + amount);
	}
}
