package com.woowacourse.racingGame.domain;

public class RandomNoCache {
	static final int low = 0;
	static final int high = 9;
	static final RandomNo[] cache;

	static {
		cache = new RandomNo[(high - low) + 1];
		int i = low;
		for (int j = 0; j < cache.length; j++) {
			cache[j] = new RandomNo(i++);
		}
	}

	private RandomNoCache() {
	}
}
