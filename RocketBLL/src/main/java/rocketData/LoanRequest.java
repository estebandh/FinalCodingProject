package rocketData;

import java.io.Serializable;

public class LoanRequest implements Serializable {

	private int iTerm;
	private double dRate;
	private double dAmount;
	private int iCreditScore;
	private int iDownPayment;
	private double dPayment;
	private int income;
	private int expenses;
	
	public int getIncome() {
		return income;
	}
	public void setIncome(int income) {
		this.income = income;
	}
	public int getExpenses() {
		return expenses;
	}
	public void setExpenses(int expenses) {
		this.expenses = expenses;
	}
	public LoanRequest() {
		super();
	}
	public int getiTerm() {
		return iTerm;
	}
	public void setiTerm(int iTerm) {
		this.iTerm = iTerm;
	}
	public double getdRate() {
		return dRate;
	}
	public void setdRate(double dRate) {
		this.dRate = dRate;
	}
	public double getdAmount() {
		return dAmount;
	}
	public void setdAmount(double dAmount) {
		this.dAmount = dAmount;
	}
	public int getiCreditScore() {
		return iCreditScore;
	}
	public void setiCreditScore(int iCreditScore) {
		this.iCreditScore = iCreditScore;
	}
	public int getiDownPayment() {
		return iDownPayment;
	}
	public void setiDownPayment(int iDownPayment) {
		this.iDownPayment = iDownPayment;
	}
	public double getdPayment() {
		return dPayment;
	}
	public void setdPayment(double dPayment) {
		this.dPayment = dPayment;
	}
	
	
}
