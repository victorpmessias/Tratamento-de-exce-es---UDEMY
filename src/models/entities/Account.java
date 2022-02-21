/**
 * 
 */
package models.entities;

import java.util.Objects;

import models.exceptions.DomainException;

/**
 * @author victor
 *
 */
public class Account {
	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;
	
	
	public Account() {
	}


	public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
		
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}


	public Integer getNumber() {
		return number;
	}


	public void setNumber(Integer number) {
		this.number = number;
	}


	public String getHolder() {
		return holder;
	}


	public void setHolder(String holder) {
		this.holder = holder;
	}


	public Double getWithdrawLimit() {
		return withdrawLimit;
	}


	public void setWithdrawLimit(Double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}


	public Double getBalance() {
		return balance;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(balance, holder, number, withdrawLimit);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		return Objects.equals(balance, other.balance) && Objects.equals(holder, other.holder)
				&& Objects.equals(number, other.number) && Objects.equals(withdrawLimit, other.withdrawLimit);
	}


	//	Methods
	public void deposit(Double amount) {
		this.balance += amount;
	}
	
	public void withdraw(Double amount) throws DomainException{
		if(amount>this.withdrawLimit) {
			throw new DomainException("The amount exceeds withdraw limit");
		}
		if(amount>this.balance) {
			throw new DomainException("Not enough balance");
		}
		this.balance -= amount;
		
	}
	
			
}
