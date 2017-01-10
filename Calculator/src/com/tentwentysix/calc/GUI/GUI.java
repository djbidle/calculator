package com.tentwentysix.calc.GUI;

import java.awt.GridLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

/**
 * 
 * @author David Bidle
 *
 **/
public class GUI extends JFrame {

	/**
	 * 
	 */
	private final long serialVersionUID = 1L;
	
	
	JFrame frame = new JFrame("Calculator");
	CalcButtons calcButtons = new CalcButtons();
	
	public GUI() {
	
		//configures window 
		frame.setPreferredSize(new Dimension(325, 250));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		frame.add(calcButtons);
		
		//makes window visible
		frame.pack();
		frame.setVisible(true);
	
	}

}
