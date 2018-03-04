package com.andrzejpudzisz.LCGTest;

import java.math.BigInteger;

class Test {
	
	private BigInteger[] x, t, zeroes;
	private BigInteger a, c, m;
	LCG lcg;
	
	private BigInteger lcgNumOld, lcgNum, testNum;
	
	Test(LCG lcg) {
		this.lcg = lcg;
		
		x = new BigInteger[7];
		t = new BigInteger[x.length - 1];
		zeroes = new BigInteger[t.length - 2];
		
		for(int i = 0; i < x.length; i++) {
			x[i] = getLCGOut();
		}
		
		calc();
	}
	
	private void calc() {
		for(int i = 0; i < t.length; i++) {
			t[i] = x[i + 1].subtract(x[i]);
		}
		
		for(int i = 0; i < zeroes.length; i++) {
			zeroes[i] = t[i + 2].multiply(t[i]).subtract(t[i + 1].multiply(t[i + 1]));
		}
		
		m = zeroes[3].gcd(zeroes[2].gcd(zeroes[1].gcd(zeroes[0])));
		
		a = x[2].subtract(x[1]).multiply(x[1].subtract(x[0]).modInverse(m)).mod(m);
		
		c = x[1].subtract(x[0].multiply(a)).mod(m);
	}
	
	BigInteger getLCGOut() {
		lcgNumOld = lcgNum;
		lcgNum = lcg.getRand();
		return lcgNum;
	}
	
	BigInteger predictLcg() {
		testNum = (a.multiply(lcgNumOld).add(c)).mod(m);
		return testNum;
	}
	
}
