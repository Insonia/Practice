package isA;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ColorDialog extends JDialog {
	private int redValue,greenValue,blueValue;
	private Color color = null;
	
	private JSlider jslRed = new JSlider(0,128);
	private JSlider jslGreen = new JSlider(0,128);
	private JSlider jslBlue = new JSlider(0,128);
	
	private JButton jbtOK = new JButton("OK");
	private JButton jbtCancel = new JButton("Cancel");
	
	private JPanel jpSelectedColor = new JPanel();
	
	public ColorDialog(){
		this(null,true);
	}
	
	public ColorDialog(Frame parent, boolean modal){
		super(parent,modal);
		setTitle("Choose Color");
		
		JPanel jpBUttons = new JPanel();
		jpBUttons.add(jbtOK);
		jpBUttons.add(jbtCancel);
		
		JPanel jpLabels = new JPanel(new GridLayout(3,1));
		jpLabels.add(new JLabel("Red"));
		jpLabels.add(new JLabel("Green"));
		jpLabels.add(new JLabel("Blue"));
		
		JPanel jpSlides = new JPanel();
		jpSlides.setLayout(new GridLayout(3,0));
		jpSlides.add(jslRed);
		jpSlides.add(jslGreen);
		jpSlides.add(jslBlue);
		
		JPanel jpSelectorColor = new JPanel();
		jpSelectorColor.setLayout(new BorderLayout());
		jpSelectorColor.setBorder(BorderFactory.createTitledBorder("Select Color"));
		jpSelectorColor.add(jpLabels,BorderLayout.WEST);
		jpSelectorColor.add(jpSlides,BorderLayout.CENTER);
		
		JPanel jpColor = new JPanel();
		jpColor.setLayout(new BorderLayout());
		jpColor.add(jpSelectorColor,BorderLayout.SOUTH);
		jpColor.add(jpSelectedColor,BorderLayout.CENTER);
		
		add(jpBUttons,BorderLayout.SOUTH);
		add(jpColor,BorderLayout.CENTER);
		pack();
		
		jbtOK.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
			}
		});
		
		jbtCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				color = null;
				setVisible(false);
			}
		});
		
		jslRed.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				redValue = jslRed.getValue();
				color = new Color(redValue,greenValue,blueValue);
				jpSelectedColor.setBackground(color);
			}
		});
		
		jslGreen.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				greenValue = jslGreen.getValue();
				color = new Color(redValue,greenValue,blueValue);
				jpSelectedColor.setBackground(color);
			}
		});
		
		jslBlue.addChangeListener(new ChangeListener() {
	
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				blueValue = jslBlue.getValue();
				color = new Color(redValue,greenValue,blueValue);
				jpSelectedColor.setBackground(color);
			}
		});
	}
	
	public Color getColor(){
		return color;
	}
}
