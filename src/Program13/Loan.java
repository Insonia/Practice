package Program13;

import java.sql.Date;

public class Loan {
	private double annualInterestRate;
	private int year;
	private double loanAmout;
	private Date loanDate;
	
	public Loan(){
		this(2.5,1,1000);
	}
	
	public Loan(double interest, int year, double loanAmout){
		this.annualInterestRate = interest;
		this.year = year;
		this.loanAmout = loanAmout;
	}

	public double getAnnualInterestRate() {
		return annualInterestRate;
	}

	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public double getLoanAmout() {
		return loanAmout;
	}

	public void setLoanAmout(double loanAmout) {
		this.loanAmout = loanAmout;
	}

	public Date getLoanDate() {
		return loanDate;
	}

	public void setLoanDate(Date loanDate) {
		this.loanDate = loanDate;
	}
	
	public double getMOntlyPayment() {
		double monthlyInterestRate = annualInterestRate /1200;
		double monthlyPayment = loanAmout * monthlyInterestRate / (1 - (Math.pow(1/(1+monthlyInterestRate), year * 12)));
		return monthlyPayment;
	}
	
	public double getTotalPayment() {
		double totalPayment = getMOntlyPayment() * year *12;
		return totalPayment;
	}
}
