package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/*
 * Copyright (c) 2020 by 또동페어
 * All rights reserved.
 *
 * WinnerTest.java
 * winner 테스트 클래스
 *
 * @author      또동페어
 * @version     1.0
 * @date        13 Feb 2020
 *
 */
public class WinnerTest {
	@DisplayName("승리자 이름 목록을 제대로 가져오는지 테스트")
	@Test
	void TestGetWinnerNames() {
		List<Car> winners = Arrays.asList(new Car("또동", 20), new Car("두둥", 20));
		Winner winner = new Winner(winners);
		assertThat(winner.getWinnerNames()).containsExactly("또동", "두둥");
	}
}
