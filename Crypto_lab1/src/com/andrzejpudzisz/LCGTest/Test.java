package com.andrzejpudzisz.LCGTest;

class Test {
	
	private long x, a, c, m;
	LCG lcg;
	
	private long lcgNum, testNum;
	
	
	Test(LCG lcg) {
		this.lcg = lcg;
	}
	
	long getLCGOut() {
		lcgNum = lcg.getRand();
		return lcgNum;
	}
	
	long predictLcg() {
		return testNum;
	}
	
}
