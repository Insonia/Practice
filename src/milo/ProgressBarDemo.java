package milo;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingWorker;

import milo.SwingWorkerDemo.ComputePrime;

public class ProgressBarDemo extends JFrame {
	private JProgressBar jpb = new JProgressBar();
	private JTextArea jtaResult = new JTextArea();
	private JTextField jtfPrimeCount = new JTextField(8);
	private JButton jbtDisplay = new JButton("Display Prime");
	
	public ProgressBarDemo(){
		jpb.setStringPainted(true);
		jpb.setValue(0);
		jpb.setMaximum(100);
		
		jtaResult.setWrapStyleWord(true);
		jtaResult.setLineWrap(true);
		
		JPanel panel = new JPanel();
		panel.add(new JLabel("Enter the prime number count"));
		panel.add(jtfPrimeCount);
		panel.add(jbtDisplay);
		
		add(jpb,BorderLayout.NORTH);
		add(new JScrollPane(jtaResult),BorderLayout.CENTER);
		add(panel,BorderLayout.SOUTH);
		
		jbtDisplay.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				    ComputePrime taskComputePrime = new ComputePrime(Integer.parseInt(jtfPrimeCount.getText()),jtaResult);
				    
				    taskComputePrime.addPropertyChangeListener(new PropertyChangeListener() {
						
						@Override
						public void propertyChange(PropertyChangeEvent evt) {
							// TODO Auto-generated method stub
							if("progress".equals(evt.getPropertyName())){
								jpb.setValue((Integer)evt.getNewValue());
							}
						}
					});
				    taskComputePrime.execute();
			}
		});
	}
	
	static class ComputePrime extends SwingWorker<Integer, Integer>{
		private int count;
		private JTextArea result;
		
		public ComputePrime(int count, JTextArea result){
			this.count = count;
			this.result = result;
		}

		@Override
		protected Integer doInBackground() throws Exception {
			// TODO Auto-generated method stub
			publishPrimeNumbers(count);
			
			return 0;
		}
		
		protected void	process(List<Integer> list){
			for(int i=0; i<list.size(); i++)
				result.append(list.get(i) + " ");
		}
		
		private void publishPrimeNumbers(int n) {
			int count =0 ;
			int number = 2;
			
			while(count <= n){
				if(isPrime(number)){
					count++;
					setProgress(100 * count / n);
					publish(number);
				}
				
				number++;
			}
				
		}
		
		private static boolean isPrime(int number){
			for(int divisor = 2; divisor <= number /2 ; divisor++){
				if(number % divisor == 0){
					return false;
				}
			}
			
			return true;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new ProgressBarDemo();
		frame.setTitle("MIlo SB");
		frame.setSize(500,150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
