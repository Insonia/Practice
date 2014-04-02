package sb;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CircleController extends JPanel {
	private CircleModel model;
	private JTextField jtfRadius = new JTextField();
	private JComboBox jcbFilled = new JComboBox(new Boolean[]{new Boolean(false), new Boolean(true)});
	
	public CircleController(){
		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(2,1));
		panel1.add(new JLabel("Radius"));
		panel1.add(new JLabel("Filled"));
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(2,1));
		panel2.add(jtfRadius);
		panel2.add(jcbFilled);
		
		setLayout(new BorderLayout());
		add(panel1,BorderLayout.WEST);
		add(panel2,BorderLayout.CENTER);
		
		jtfRadius.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(getModel() == null)return;
				getModel().setRadius(new Double(jtfRadius.getText().trim()).doubleValue());
			}
		});
		jcbFilled.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(getModel() ==null)return;
				getModel().setFiiled(((Boolean)jcbFilled.getSelectedItem()).booleanValue());
			}
		});
	}

	public CircleModel getModel() {
		return model;
	}

	public void setModel(CircleModel model) {
		this.model = model;
	}
}
