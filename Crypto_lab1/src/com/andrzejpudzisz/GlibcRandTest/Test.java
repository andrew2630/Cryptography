package com.andrzejpudzisz.GlibcRandTest;

import java.math.BigInteger;

class Test {

	private BigInteger[] out;
	private BigInteger prediction, glibcNumOld, glibcNum;
	private GlibcRand rand;
	int i;
	
	Test(GlibcRand rand) {
		this.rand = rand;
		
		out = new BigInteger[10000];
		
		for(i = 0; i < 31; i++) {
			out[i] = getGlibcOut();
		}

		prediction = out[i - 31].add(out[i - 3]).mod(BigInteger.ONE.shiftLeft(31));
	}
	
	BigInteger getGlibcOut() {
		glibcNumOld = glibcNum;
		glibcNum = rand.getRand();
		return glibcNum;
	}
	
	BigInteger predictGlibc() {
		i++;
		out[i] = out[i - 31].add(out[i - 3]).mod(BigInteger.ONE.shiftLeft(31));
		prediction = out[i];
		return prediction;
	}
	
}
