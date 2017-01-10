/**
 * 
 */
package com.tentwentysix.calc.GUI;

import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;

import com.tentwentysix.calc.Calculator;

/**
 * @author David Bidle
 *
 */
public class CalcButtons extends JPanel implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	String[] buttonString = {"7", "8", "9", "+",
							 "4", "5", "6", "-",
							 "1", "2", "3", "*",
							 ".", "/", "C", "√",
							 "+/-", "=", "0"};

	JPanel[] panelRow = new JPanel[5];
	JButton[] button = new JButton[19];
	public JTextArea display = new JTextArea(1, 20);
	Font font = new Font("Times New Roman", Font.BOLD, 14);
	
	int[] dimWidth = {300, 45, 100, 90};
	int[] dimHeight = {35, 40};
	
	Dimension displayDim = new Dimension(dimWidth[0], dimHeight[0]);
	Dimension regularDim = new Dimension(dimWidth[1], dimHeight[1]);
	Dimension rColumnDim = new Dimension(dimWidth[2], dimHeight[1]);
	Dimension zeroButDim = new Dimension(dimWidth[3], dimHeight[1]);
	
	FlowLayout flowOne = new FlowLayout(FlowLayout.CENTER, 2, 4);
	FlowLayout flowTwo = new FlowLayout(FlowLayout.CENTER, 0, 0);
	
	private static Calculator calc;
	
	public CalcButtons() {
		
		CalcButtons.calc = new Calculator(this);
		
		setLayout(new GridLayout(5, 5));
		setDesign();
		
		for(int i = 0; i < 5; i++)
			panelRow[i] = new JPanel();
		panelRow[0].setLayout(flowOne);
		for(int i = 1; i < 5; i++)
			panelRow[i].setLayout(flowTwo); 
		
		for(int i = 0; i < 19; i++) {
			button[i] = new JButton();
			button[i].setText(buttonString[i]);
			button[i].setFont(font);
			button[i].addActionListener(this);
			}
		
		display.setFont(font);
		display.setEditable(false);
		display.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		display.setPreferredSize(displayDim);
		for(int i = 0; i < 14; i++)
			button[i].setPreferredSize(regularDim);
		for(int i = 14; i < 18; i++)
			button[i].setPreferredSize(rColumnDim);
		button[18].setPreferredSize(zeroButDim);
		
		panelRow[0].add(display);
		add(panelRow[0]);
		
		for(int i = 0; i < 4; i++)
			panelRow[1].add(button[i]);
		panelRow[1].add(button[14]);
		add(panelRow[1]);
		
		for(int i = 4; i < 8; i++)
			panelRow[2].add(button[i]);
		panelRow[2].add(button[15]);
		add(panelRow[2]);
		
		for(int i = 8; i < 12; i++)
			panelRow[3].add(button[i]);
		panelRow[3].add(button[16]);
		add(panelRow[3]);
		
		panelRow[4].add(button[18]);
		for(int i = 12; i < 14; i++)
			panelRow[4].add(button[i]);
		panelRow[4].add(button[17]);
		add(panelRow[4]);
		
	}

	/**
	 * 
	 */
	private final void setDesign() {
		
		try{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
			
		} catch(Exception e){
		}
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent actEvent) {
		
		if(actEvent.getSource() == button[0])
			display.append("7");
		if(actEvent.getSource() == button[1])
			display.append("8");
		if(actEvent.getSource() == button[2])
			display.append("9");
		if(actEvent.getSource() == button[3]) {
			//add function[0]
			calc.temporary[0] = Double.parseDouble(display.getText());
			calc.function[0] = true;
			display.setText("");
		}
		
		if(actEvent.getSource() == button[4])
			display.append("4");
		if(actEvent.getSource() == button[5])
			display.append("5");
		if(actEvent.getSource() == button[6])
			display.append("6");
		if(actEvent.getSource() == button[7]) {
			//subtract function[1]
			calc.temporary[0] = Double.parseDouble(display.getText());
			calc.function[1] = true;
			display.setText("");
		}
		
		if(actEvent.getSource() == button[8])
			display.append("1");
		if(actEvent.getSource() == button[9])
			display.append("2");
		if(actEvent.getSource() == button[10])
			display.append("3");
		if(actEvent.getSource() == button[11]) {
			//multiply function[2]
			calc.temporary[0] = Double.parseDouble(display.getText());
			calc.function[2] = true;
			display.setText("");
		}
		
		if(actEvent.getSource() == button[12])
			display.append(".");
		if(actEvent.getSource() == button[13]) {
			//divide function[3]
			calc.temporary[0] = Double.parseDouble(display.getText());
			calc.function[3] = true;
			display.setText("");
		}
		
		if(actEvent.getSource() == button[14])
			calc.clear();
		if(actEvent.getSource() == button[15])
			calc.getSqrt();
		if(actEvent.getSource() == button[16])
			calc.getPosNeg();
		if(actEvent.getSource() == button[17])
			calc.getResult();
		if(actEvent.getSource() == button[18])
			display.append("0");
		
	}

}


