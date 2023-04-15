package com.antares.jinsei;

import java.awt.Dimension;

import javax.swing.JFrame;

class JinseiApplication {

	public static void main(String... args) {

		JFrame frame = new JFrame("Jinsei");
		frame.setSize(400, 700);
		frame.setLocation(1200, 100);
		frame.setMinimumSize(new Dimension(400, 700));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}