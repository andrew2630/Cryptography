package com.andrzejpudzisz.LCGTest;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class UI extends JFrame implements ActionListener {

	private LCG lcg;
	private Test test;
	private boolean result;
	
	private int k, sumRes, sumK;

	private JLabel labelLCG, labelTest, labelResult, labelK, labelSumRes, labelSumK;
	private JTextField txtLCG, txtTest, txtResult, txtK, txtSumRes, txtSumK;
	private JButton btnNext, btnKNext;
	
	public UI() {
		lcg = new LCG(25214903917l, 11, (long) Math.pow(2, 48));
		test = new Test(lcg);
		
		setMinimumSize(new Dimension(600, 300));
		setTitle("LCG");
		setVisible(true);
		makeGUI();
	}
	
	private void makeGUI() {
		labelLCG = new JLabel("LCG", SwingConstants.CENTER);
		labelTest = new JLabel("Test", SwingConstants.CENTER);
		labelResult = new JLabel("Equal?", SwingConstants.CENTER);
		labelK = new JLabel("K", SwingConstants.CENTER);
		labelSumRes = new JLabel("Positive results", SwingConstants.CENTER);
		labelSumK = new JLabel("Attempts no.", SwingConstants.CENTER);
		txtLCG = new JTextField(20);
		txtTest = new JTextField(20);
		txtResult = new JTextField(10);
		txtK = new JTextField(10);
		txtSumRes = new JTextField(10);
		txtSumK = new JTextField(10);
		btnNext = new JButton("Next one");
		btnKNext = new JButton("Next K times");
		
		LinkedList<JLabel> labelList = new LinkedList<JLabel>();
		LinkedList<JTextField> txtList = new LinkedList<JTextField>();
		LinkedList<JButton> btnList = new LinkedList<JButton>();
		
		setLayout(new GridLayout(0, 2));
				
		add(labelLCG);
		add(txtLCG);
		add(labelTest);
		add(txtTest);
		
		
		validate();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	private void calcResult() {
		result = test.getLCGOut() == test.predictLcg();
	}
	
	public static void main(String[] args) {
		new UI();
	}

}
