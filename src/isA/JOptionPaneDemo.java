package isA;

import java.awt.Dimension;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Program13.Loan;

public class JOptionPaneDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object[] rateList = new Object[25];
		int i =0;
		for(double rate = 5; rate <=8; rate += 1.0/ 8)
			rateList[i++] = new Double(rate);
		
		Object annualInteterestRateObject = JOptionPane.showInputDialog(null, "Select annual interest rate",
				"JOptionPaneDemo", JOptionPane.QUESTION_MESSAGE, null, rateList, null);
		double annualInterestRate = ((Double)annualInteterestRateObject).doubleValue();
		
		Object[] yearList = {new Integer(7), new Integer(15), new Integer(30)};
		
		Object numberOfYearObject = JOptionPane.showInputDialog(null, "Select number of years", "JOptionPaneDemo",
				JOptionPane.QUESTION_MESSAGE, null, yearList, null);
		int numberOfYear = ((Integer)numberOfYearObject).intValue();
		
		String loanAmountString = JOptionPane.showInputDialog(null,"Enter loan amout, \nfor example, 150000 for $150000","JOptionPaneDemo",
				JOptionPane.QUESTION_MESSAGE);
		double loanAmout = Double.parseDouble(loanAmountString);
		
		Loan loan = new Loan(annualInterestRate,numberOfYear,loanAmout);
		double monthlyPayment = loan.getMOntlyPayment();
		double totalPayment = loan.getTotalPayment();
		
		String output = "Interest Rate: " + annualInterestRate + "%" + "Number of years: " 
				+ numberOfYear + " Loan Amout: $" + loanAmout + "\nMonthly Payment: " + "$"
				+ (int)(monthlyPayment * 100 ) / 100.0 + "\nTotal Payment: $"
				+ (int)(monthlyPayment * 12 * numberOfYear * 100) / 100.0 + "\n";
		
		double monthlyInterestRate = annualInterestRate / 1200;
		
		double balance = loanAmout;
		double interest;
		double principal;
		
		output += "\nPayment#\tInterest\tPrincpal\tBalance\n";
		
		for(int i1= 1; i1 <= numberOfYear * 12; i1++){
			interest = (int)(monthlyInterestRate * balance * 100) / 100.0;
			principal = (int)((monthlyPayment - interest) * 100) / 100.0;
			balance  = (int)((balance - principal) * 100) / 100.0;
			output += i1 + "\t" + interest + "\t" +principal +"\t" + balance + "\n";
		}
		
		JScrollPane jsp = new JScrollPane(new JTextArea(output));
		jsp.setPreferredSize(new Dimension(400, 200));
		JOptionPane.showMessageDialog(null, jsp, "JOptionPaneDemo", JOptionPane.INFORMATION_MESSAGE, null);
		
	}

}
