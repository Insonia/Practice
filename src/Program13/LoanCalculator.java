package Program13;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class LoanCalculator extends JFrame {
	
	private JTextField jtfAnnualInterestRate = new JTextField();
	private JTextField jtfNumberOfYears = new JTextField();
	private JTextField jtfLoanAmount = new JTextField();
	private JTextField jtfMonthlyPaymen = new JTextField();
	private JTextField jtfTotalPayment = new JTextField();
	
	private JButton jbtComputeLoan = new JButton("Compute Payment");
	
	public LoanCalculator(){
		JPanel p1 = new JPanel(new GridLayout(5,2));
		p1.add(new Label("Annual Interest Rate"));
		p1.add(jtfAnnualInterestRate);
		p1.add(new Label("Number of Years"));
		p1.add(jtfNumberOfYears);
		p1.add(new Label("Loan Amout"));
		p1.add(jtfLoanAmount);
		p1.add(new Label("Monthly Payment"));
		p1.add(jtfMonthlyPaymen);
		p1.add(new Label("Total Payment"));
		p1.add(jtfTotalPayment);
		p1.setBorder(new TitledBorder("Enter loan amout, interest rate, and year"));
		
		JPanel p2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		p2.add(jbtComputeLoan);
		
		add(p1,BorderLayout.CENTER);
		add(p2,BorderLayout.SOUTH);
		
		jbtComputeLoan.addActionListener(new ButtonListener());
	}
	
	private class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			double interest = Double.parseDouble(jtfAnnualInterestRate.getText());
			int year = Integer.parseInt(jtfNumberOfYears.getText());
			double loanAmout = Double.parseDouble(jtfLoanAmount.getText());
			
			Loan loan = new Loan(interest,year,loanAmout);
			
			jtfMonthlyPaymen.setText(String.format("%.2f", loan.getMOntlyPayment()));
			jtfTotalPayment.setText(String.format("%.2f", loan.getTotalPayment()));
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new LoanCalculator();
		frame.pack();
		frame.setTitle("Milo SB");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
