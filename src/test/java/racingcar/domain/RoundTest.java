package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/*
 * Copyright (c) 2020 by 또동페어
 * All rights reserved.
 *
 * RoundTest.java
 * 라운드 객체 테스트
 *
 * @author      또동페어
 * @version     1.0
 * @date        12 Feb 2020
 *
 */
class RoundTest {
    @DisplayName("부적절한 라운드 횟수 입력")
    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    void testRacingGame(int numberOfRound) {
        assertThatThrownBy(() -> new Round(numberOfRound))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("round number must be positive");
    }
}