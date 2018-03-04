package com.andrzejpudzisz.LCGTest;

import java.math.BigInteger;

class LCG {
	
	//i.e.: a = 25214903917; c = 11; m = Math.pow(2, 48);
	private BigInteger x, a, c, m;

	LCG(BigInteger a, BigInteger c, BigInteger m) {
		x = BigInteger.valueOf(1);
		this.a = a;
		this.c = c;
		this.m = m;
		
		for(int i = 0; i < 64; i++) {
			getRand();
		}
	}
	
	BigInteger getRand() {
		x = (a.multiply(x).add(c)).mod(m);
		return x;
	}
	
}
