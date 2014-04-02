package com.handsome.yin;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.handsome.yin.HuffmanCode.Tree;

public class HuffmanTreeControl {
	private Tree tree;
	private JTextField jtfString = new JTextField();
	private JTextField jtfBit = new JTextField();
	private JButton jbtShowHuffmanTree = new JButton();
	private JButton jbtDecode = new JButton();
	
	public HuffmanTreeControl(){
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(1,3));
		p1.add(new JLabel("Enter a text:"));
		p1.add(jtfString);
		p1.add(jbtShowHuffmanTree);
		
		JPanel p2 = new JPanel();
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
