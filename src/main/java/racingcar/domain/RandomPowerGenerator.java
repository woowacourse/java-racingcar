package racingcar.domain;

import java.util.Random;

/*
 * Copyright (c) 2020 by 또동페어
 * All rights reserved.
 *
 * RandomNumberGenerator.java
 * 난수 생성을 담당하는 클래스
 *
 * @author      또동페어
 * @version     1.0
 * @date        12 Feb 2020
 *
 */
public class RandomPowerGenerator implements PowerGenerator {
	private static final Random random = new Random();
	private static final int RANDOM_BOUND = 10;

	public Power generatePower() {
		random.setSeed(System.nanoTime());
		return new Power(random.nextInt(RANDOM_BOUND));
	}
}
