package main;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.After;

import org.junit.Test;

public class AccountTest {
	// Create two new accounts
	Account a = new Account(1122, 20000);
	Account b = new Account(1010, 20000);

	// Set Annual Interest Rate for both accounts
	@Before
	public void setup() {
		a.setAnnualInterestRate(.045);
		b.setAnnualInterestRate(.045);
	}

	// Test the withdraw and deposit methods 
	// Use the first account: take out an amount less than the balance, 
	// then depositing more
	@Test
	public void withdrawalTest() throws InsufficientFundsException {
		a.withdraw(2500);
		assertTrue(Math.abs(a.getBalance() - 17500.0) < .01);
		a.deposit(3000);
		assertTrue(Math.abs(a.getBalance() - 20500.0) < .01);
	}
	
	// Test the InsufficientFundsException by attempting to withdraw more
	// than the balance
	@Test(expected=InsufficientFundsException.class)
	public void overwithdrawalTest() throws InsufficientFundsException {
		b.withdraw(30000);
	}

	@After
	public void printStats() {
		System.out.printf("Your balance is $%3.2f \n", a.getBalance());
		System.out.printf("Your monthly interest rate is %1.2f \n", a.getAnnualInterestRate() * 100.0);
		System.out.printf("Your account was created on %tB %<te, %<tY %<tT %<Tp%n", a.getDateCreated());
	}

}
