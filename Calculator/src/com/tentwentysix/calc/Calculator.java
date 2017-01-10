package com.tentwentysix.calc;

import com.tentwentysix.calc.GUI.CalcButtons;

/**
 * @author David Bidle
 *
 */

public class Calculator {
	
	private static CalcButtons calcButtons;

	public boolean[] function = new boolean[4];
	public double[] temporary = {0, 0};
	
	public Calculator(CalcButtons calcButtons) {
		
		Calculator.calcButtons = calcButtons;
		
		for (int i = 0; i < 4; i++){
			function[i] = false;
			
		}
	
	}	
		
	public void clear(){
	
		calcButtons.display.setText("");
		try{
			calcButtons.display.setText("");
			for(int i = 0; i < 4; i++)
				function[i] = false;
			for(int i = 0; i < 2; i++)
				temporary[i] = 0;
		} catch(NullPointerException e) { 
		}	
	}

	public void getSqrt() {
		
		try{
			double value = Math.sqrt(Double.parseDouble(calcButtons.display.getText()));
			calcButtons.display.setText(Double.toString(value));
		} catch(NumberFormatException e) {
		}
	}

	public void getPosNeg() {
		
		try{
			double value = Double.parseDouble(calcButtons.display.getText());
			if(value != 0) {
				value = value * (-1);
				calcButtons.display.setText(Double.toString(value));
			} 
			else{	
			}	
		} catch(NumberFormatException e) {	
		}
	}

	public void getResult() {
		
		double result = 0;
		temporary[1] = Double.parseDouble(calcButtons.display.getText());
		String temp0 = Double.toString(temporary[0]);
		String temp1 = Double.toString(temporary[1]);

		try {
			if(temp0.contains("-")) {
				String[] temp00 = temp0.split("-", 2);
				temporary[0] = (Double.parseDouble(temp00[1]) * -1);
			}
			if(temp1.contains("-")) {
				String[] temp11 = temp1.split("-", 2);
				temporary[1] = (Double.parseDouble(temp11[1]) * -1);
			}
		} catch(ArrayIndexOutOfBoundsException e) {
		}
		
		try{
			if(function[2] == true)
				result = temporary[0] * temporary[1];
			else if(function[3] == true)
				result = temporary[0] / temporary[1];
			else if(function[0] == true)
				result = temporary[0] + temporary[1];
			else if(function[1] == true)
				result = temporary[0] - temporary[1];
			calcButtons.display.setText(Double.toString(result));
			for(int i = 0; i < 4; i++)
				function[i] = false;
		} catch(NumberFormatException e) {
		}
	}
}