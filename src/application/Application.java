package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import models.entities.Account;
import models.exceptions.DomainException;

public class Application {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		try {
		System.out.println("Enter account data");
		System.out.print("Number: ");
		Integer number = scan.nextInt();
		scan.nextLine();
		System.out.print("Holder: ");
		String holder = scan.nextLine();
		System.out.print("Initial balance: ");
		Double balance = scan.nextDouble();
		System.out.print("Withdraw Limit: ");
		Double withdrawLimit = scan.nextDouble();
		Account account = new Account(number, holder, balance, withdrawLimit);
		
		System.out.print("Enter amount for withdraw: ");
		Double withdraw = scan.nextDouble();
		account.withdraw(withdraw);
		System.out.println("New balance: " + account.getBalance() );
		}
		catch(DomainException e) {
			System.out.println("Withdraw error: " + e.getMessage());
		}
		catch(InputMismatchException e) {
			System.out.println("Input error: " + e);
		}
		scan.close();
	

}
		
}
