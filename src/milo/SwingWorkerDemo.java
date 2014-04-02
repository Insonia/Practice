package milo;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingWorker;

public class SwingWorkerDemo extends JFrame {
	private JButton jbtComputeWithSwingWorker = new JButton("Compute");
	private JButton jbtCompute = new JButton("Compute");
	private JTextField jtfLimit1 = new JTextField(8);
	private JTextField jtfLimit2 = new JTextField(8);
	private JTextField jtfResult1 = new JTextField(6);
	private JTextField jtfResult2 = new JTextField(6);
	private JLabel jlb = new JLabel("The number of prime numbers <= ");
	
	public SwingWorkerDemo(){
		JPanel panel1 = new JPanel(new GridLayout(2, 1));
		panel1.setBorder(BorderFactory.createTitledBorder("Using SwingWorker"));
		JPanel panel11 = new JPanel();
		panel11.add(new JLabel("The number of prime numbers <="));
		panel11.add(jtfLimit1);
		panel11.add(new JLabel("is"));
		panel11.add(jtfResult1);
		JPanel panel12 = new JPanel();
		panel12.add(jbtComputeWithSwingWorker);
		panel1.add(panel11);
		panel1.add(panel12);
		
		JPanel panel2 = new JPanel(new GridLayout(2, 1));
		panel2.setBorder(BorderFactory.createTitledBorder("Without Using SwingWorker"));
		JPanel panel21 = new JPanel();
		panel21.add(jlb);
		panel21.add(jtfLimit2);
		panel21.add(new JLabel("is"));
		panel21.add(jtfResult2);
		JPanel panel22 = new JPanel();
		panel22.add(jbtCompute);
		panel2.add(panel21);
		panel2.add(panel22);
		
		setLayout(new GridLayout(1, 2));
		add(panel1);
		add(panel2);
		
		jbtComputeWithSwingWorker.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new ComputePrime(Integer.parseInt(jtfLimit1.getText()), jtfResult1).execute();
			}
		});
		
		jbtCompute.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int count = ComputePrime.getNumberOfPrimes(Integer.parseInt(jtfLimit2.getText()));
				jtfResult2.setText(count + "");
			}
		});
	}
	
	static class ComputePrime extends SwingWorker<Integer, Object>{
		private int limit;
		private JTextField result;
		
		public ComputePrime(int limit, JTextField result){
			this.limit = limit;
			this.result = result;
		}
		
		@Override
		protected Integer doInBackground() throws Exception {
			// TODO Auto-generated method stub
			return getNumberOfPrimes(limit);
		}
		
		protected void done() {
			try{
				result.setText(get().toString());
			}catch(Exception ex){
				result.setText(ex.getMessage());
			}
		}
		
		public static int getNumberOfPrimes(int limit){
			int count = 0;
			int number = 2;
			
			while(number <= limit){
				if(isPrime(number)){
					count ++;
				}
				
				number ++;
			}
			
			return count;
		}
		
		private static boolean isPrime(int number){
			for(int divisor = 2; divisor <= number /2; divisor++){
				if(number % divisor ==0)
					return false;
			}
			
			return true;
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new SwingWorkerDemo();
		frame.setTitle("Milo SB");
		frame.setLocationRelativeTo(null);
		frame.setSize(1000,200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
