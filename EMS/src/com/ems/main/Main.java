package com.ems.main;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		String value = JOptionPane.showInputDialog("Enter the amount");
		try {
			System.out.println(Integer.parseInt(value));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Invalid value. Enter numbers only");
		}
	}
}
