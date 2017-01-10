package com.tentwentysix.calc;

/**
 * @author David Bidle
 *
 */

import javax.swing.SwingUtilities;

import com.tentwentysix.calc.GUI.*;


public class Main {

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
	         public void run() {
	        	 
	        	//new instance of the GUIFrame
	      		GUI gui = new GUI();
	      		
	         }
				
		});

	}

}
