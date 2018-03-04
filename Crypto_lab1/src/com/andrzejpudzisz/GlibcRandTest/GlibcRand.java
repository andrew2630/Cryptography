package com.andrzejpudzisz.GlibcRandTest;

import java.math.BigInteger;

class GlibcRand {

	private BigInteger seed, max, i;
	
	GlibcRand(BigInteger seed) {
		this.seed = seed;
	}
	
	BigInteger getRand() {
		return BigInteger.valueOf(0);
	}
	
}
