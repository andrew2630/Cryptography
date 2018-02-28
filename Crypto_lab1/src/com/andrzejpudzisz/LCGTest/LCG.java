package com.andrzejpudzisz.LCGTest;

class LCG {
	
	//i.e.: a = 25214903917; c = 11; m = Math.pow(2, 48);
	private long x, a, c, m;

	LCG(long a, long c, long m) {
		x = 0;
		this.a = a;
		this.c = c;
		this.m = m;
		
		for(int i = 0; i < 64; i++) {
			getRand();
		}
	}
	
	long getRand() {
		x = (a * x + c) % m;
		return x;
	}
	
}
