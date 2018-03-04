package com.andrzejpudzisz.LCGTest;

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

	private LCG lcg;
	private Test test;
	private boolean result;
	
	private int k, sumRes, sumK;

	private JLabel labelLCG, labelTest, labelResult, labelK, labelSumRes, labelSumK;
	private JTextField txtLCG, txtTest, txtResult, txtK, txtSumRes, txtSumK;
	private JButton btnNext, btnKNext;
	
	public UI() {
		lcg = new LCG(BigInteger.valueOf(25214903917l), BigInteger.valueOf(11l), BigInteger.valueOf(281474976710656l));
		//lcg = new LCG(BigInteger.valueOf(15l), BigInteger.valueOf(11l), BigInteger.valueOf(1024l));
		test = new Test(lcg);
		k = 1;
		
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
		
		txtList.add(txtLCG);
		txtList.add(txtTest);
		txtList.add(txtResult);
		txtList.add(txtK);
		txtList.add(txtSumRes);
		txtList.add(txtSumK);
		
		setLayout(new GridLayout(0, 2));
				
		add(labelLCG);
		add(txtLCG);
		add(labelTest);
		add(txtTest);
		add(labelResult);
		add(txtResult);
		add(labelK);
		add(txtK);
		add(labelSumRes);
		add(txtSumRes);
		add(labelSumK);
		add(txtSumK);
		add(btnNext);
		add(btnKNext);
		
		for(JTextField t : txtList) {
			t.setHorizontalAlignment(JTextField.CENTER);
			t.setDisabledTextColor(new Color(0, 0, 0));
			t.setEnabled(false);
		}
		txtK.setEnabled(true);
		
		btnNext.addActionListener(e -> {
			btnNextAction(e);
		});
		
		btnKNext.addActionListener(e -> {
			btnKNextAction(e);
		});
		
		update();
		validate();
	}
	
	private void btnNextAction(ActionEvent e) {
		update();
	}
	
	private void btnKNextAction(ActionEvent e) {
		k = Integer.parseInt(txtK.getText());
		sumK += k;
		for(int i = 0; i < k; i++) {
			if(result) {
				sumRes++;
			}
			update();
		}
	}
	
	private void update() {
		BigInteger lcgNum = test.getLCGOut();
		BigInteger testNum = test.predictLcg();
		txtLCG.setText("" + lcgNum);
		txtTest.setText("" + testNum);
		calcResult(lcgNum, testNum);
		txtResult.setText("" + result);
		txtSumRes.setText("" + sumRes);
		txtSumK.setText("" + sumK);
	}
	
	private void calcResult(BigInteger lcgNum, BigInteger testNum) {
		result = lcgNum.equals(testNum);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		new UI();
	}

}
