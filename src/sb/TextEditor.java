package sb;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;

public class TextEditor extends JFrame {
	private ImageIcon icon = new ImageIcon("imag/1.png");
	
	private JMenuItem jmiOpen = new JMenuItem("Open",icon);
	private JMenuItem jmiSave = new JMenuItem("Save",icon);
	private JMenuItem jmiClear = new JMenuItem("Clear");
	private JMenuItem jmiExit = new JMenuItem("Exit");
	private JMenuItem jmiForgeground = new JMenuItem("Forgeground");
	private JMenuItem jmiBackgroud = new JMenuItem("Background");
	
	private JButton jbtOpen = new JButton(icon);
	private JButton jbtSave = new JButton(icon);
	private JLabel jlbStatus = new JLabel();
	
	private JFileChooser jFileChooser1 = new JFileChooser(new File("."));
	
	private JTextArea jta = new JTextArea();
	
	public TextEditor(){
		JMenu jMenu1 = new JMenu("File");
		jMenu1.add(jmiOpen);
		jMenu1.add(jmiSave);
		jMenu1.add(jmiClear);
		jMenu1.addSeparator();
		jMenu1.add(jmiExit);
		
		JMenu jMenu2 = new JMenu("Edit");
		jMenu2.add(jmiForgeground);
		jMenu2.add(jmiBackgroud);
		
		JMenuBar jmb = new JMenuBar();
		jmb.add(jMenu1);
		jmb.add(jMenu2);
		
		setJMenuBar(jmb);
		
		JToolBar jtb = new JToolBar();
		jtb.add(jbtOpen);
		jtb.add(jbtSave);
		
		jmiOpen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				open();
			}
		});
		
		jmiSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				save();
			}
		});
		
		jmiClear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jta.setText(null);
			}
		});
		
		jmiExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		
		jmiForgeground.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Color selectedColor = JColorChooser.showDialog(null, "Chosse Forgeground Color", jta.getForeground());
				if(selectedColor != null)
					jta.setForeground(selectedColor);
			}
		});
		
		jmiBackgroud.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Color selectedColor = JColorChooser.showDialog(null, "Choose Background Color", jta.getBackground());
				if(selectedColor != null)
					jta.setBackground(selectedColor);
			}
		});
		
		jbtOpen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				open();
			}
		});
		
		jbtSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				save();
			}
		});
		
		add(jtb,BorderLayout.NORTH);
		add(jlbStatus,BorderLayout.SOUTH);
		add(new JScrollPane(jta),BorderLayout.CENTER);
	}
	
	private void open() {
		if(jFileChooser1.showOpenDialog(this) == JFileChooser.APPROVE_OPTION)
			open(jFileChooser1.getSelectedFile());
	}
	
	private void open(File file) {
		try {
			BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));
			byte[] b = new byte[in.available()];
			in.read(b,0,b.length);
			jta.append(new String(b,0,b.length));
			in.close();
			
			jlbStatus.setText(file.getName() + " Opened");
		} catch (IOException e) {
			jlbStatus.setText("Error opening" + file.getName());
		}
	}
	
	private void save() {
		if(jFileChooser1.showSaveDialog(this) == JFileChooser.APPROVE_OPTION)
			save(jFileChooser1.getSelectedFile());
	}
	
	private void save(File file) {
		try {
			BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(file));
			
			byte[] b = jta.getText().getBytes();
			out.write(b);
			out.close();
			
			jlbStatus.setText(file.getName() + " Saved");
		} catch (IOException e) {
			jlbStatus.setText("Erroe Saving" + file.getName());
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new TextEditor();
		frame.setVisible(true);
	}

}
