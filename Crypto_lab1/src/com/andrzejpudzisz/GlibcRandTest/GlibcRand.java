package com.andrzejpudzisz.GlibcRandTest;

import java.math.BigInteger;

class GlibcRand {

	private BigInteger seed;
	private int max, i;
	private BigInteger[] r;
	
	GlibcRand(BigInteger seed, int max) {
		this.seed = seed;
		this.max = max;
		r = new BigInteger[this.max];
		i = 1;
		r[0] = seed;

		doLoop();
	}

	private void doLoop() {
		for (; i < 344; i++) {
			if (i < 31) {
				r[i] = BigInteger.valueOf(16807).multiply(r[i - 1]).mod(BigInteger.valueOf(2147483647));
				if (r[i].intValue() < 0) {
					r[i].add(BigInteger.valueOf(2147483647));
				}
			} else if (i < 34) {
				r[i] = r[i - 31];
			} else {
				r[i] = r[i - 31].add(r[i - 3]);
			}
		}
	}
	
	BigInteger getRand() {
		if (i >= max) {
			i = 0;
			doLoop();
		}
		r[i] = r[i - 31].add(r[i - 3]);
		i++;
		return r[i - 1].shiftRight(1);
	}
	
}
