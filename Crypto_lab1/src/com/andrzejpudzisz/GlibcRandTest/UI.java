package com.andrzejpudzisz.GlibcRandTest;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class UI extends JFrame implements ActionListener {

	private GlibcRand rand;
	private Test test;
	private boolean result;

	private JLabel labelGlibc, labelTest, labelResult;
	private JTextField txtGlibc, txtTest, txtResult;
	private JButton btnNext;
	
	public UI() {
		rand = new GlibcRand(BigInteger.valueOf(1l), 10000);
		test = new Test(rand);
		
		setMinimumSize(new Dimension(600, 300));
		setTitle("glibc random");
		setVisible(true);
		makeGUI();
	}
	
	private void makeGUI() {
		labelGlibc = new JLabel("glibc", SwingConstants.CENTER);
		labelTest = new JLabel("Test", SwingConstants.CENTER);
		labelResult = new JLabel("Equal?", SwingConstants.CENTER);
		txtGlibc = new JTextField(20);
		txtTest = new JTextField(20);
		txtResult = new JTextField(10);
		btnNext = new JButton("Next one");
		
		LinkedList<JLabel> labelList = new LinkedList<JLabel>();
		LinkedList<JTextField> txtList = new LinkedList<JTextField>();
		LinkedList<JButton> btnList = new LinkedList<JButton>();
		
		txtList.add(txtGlibc);
		txtList.add(txtTest);
		txtList.add(txtResult);
		
		setLayout(new GridLayout(0, 2));
				
		add(labelGlibc);
		add(txtGlibc);
		add(labelTest);
		add(txtTest);
		add(labelResult);
		add(txtResult);
		add(btnNext);
		
		for(JTextField t : txtList) {
			t.setHorizontalAlignment(JTextField.CENTER);
			t.setDisabledTextColor(new Color(0, 0, 0));
			t.setEnabled(false);
		}
		
		btnNext.addActionListener(e -> {
			btnNextAction(e);
		});
		
		update();
		validate();
	}
	
	private void btnNextAction(ActionEvent e) {
		update();
	}
	
	private void update() {
		BigInteger glibcNum = test.getGlibcOut();
		BigInteger testNum = test.predictGlibc();
		txtGlibc.setText("" + glibcNum);
		txtTest.setText("" + testNum);
		calcResult(glibcNum, testNum);
		txtResult.setText("" + result);
	}
	
	private void calcResult(BigInteger glibcNum, BigInteger testNum) {
		result = glibcNum.equals(testNum);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		new UI();
	}

}
