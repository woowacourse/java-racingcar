package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

/*
 * Copyright (c) 2020 by 또동페어
 * All rights reserved.
 *
 * PositionTest.java
 * 동력 생성 테스트 클래스
 *
 * @author      또동페어
 * @version     1.0
 * @date        15 Feb 2020
 *
 */
class PowerGeneratorTest {
	@Test
	void testGeneratingPower() {
		PowerGenerator generator = () -> new Power(5);
		Power powerLevel = generator.generatePower();
		assertThat(powerLevel).isEqualTo(new Power(5));
	}
}