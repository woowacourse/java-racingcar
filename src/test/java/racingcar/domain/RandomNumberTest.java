package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/*
 * Copyright (c) 2020 by 또링
 * All rights reserved.
 *
 * RandomNumberTest.java
 * RandomNumber 테스트
 *
 * @author      또링
 * @version     1.0
 * @date        16 Feb 2020
 *
 */
class RandomNumberTest {
    @DisplayName("랜덤 객체의 값의 범위가 유효한지 검증하는 함수 테스트")
    @ParameterizedTest
    @ValueSource(ints = {-1, 10})
    void testIsWrongRange(int number) {
        assertThatThrownBy(() -> new RandomNumber(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("The random number must be between 0 and 9");
    }
}
