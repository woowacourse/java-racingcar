package racingcar.domain;

import java.util.Objects;

/*
 * Copyright (c) 2020 by 또동페어
 * All rights reserved.
 *
 * ***.java
 * 000 담당하는 클래스
 *
 * @author      또동페어
 * @version     1.0
 * @date        14 Feb 2020
 *
 */
public class PowerLevel {
	private static final int MINIMUM_POWER_TO_RUN = 4;
	private static final int MINIMUM_POWER = 0;
	private static final int MAXIMUM_POWER = 9;

	private final int powerLevel;

	public PowerLevel(int powerLevel) {
		validatePowerLevel(powerLevel);
		this.powerLevel = powerLevel;
	}

	private void validatePowerLevel(int powerLevel) {
		if (powerLevel < MINIMUM_POWER || powerLevel > MAXIMUM_POWER) {
			throw new IllegalArgumentException();
		}
	}

	public boolean isMovable() {
		return powerLevel >= MINIMUM_POWER_TO_RUN;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		PowerLevel that = (PowerLevel)o;
		return powerLevel == that.powerLevel;
	}

	@Override
	public int hashCode() {
		return Objects.hash(powerLevel);
	}
}
