package com.woowacourse.racingGame.domain;

public class PositionCache {
	static final int low = 0;
	static final int high = 256;
	static final Position cache[];

	static {
		cache = new Position[(high - low) + 1];
		int i = low;

		for (int j = 0; j < cache.length; j++) {
			cache[j] = new Position(i++);
		}
	}

	private PositionCache() {
	}
}
