package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
public class RandomNumberTest {
    @DisplayName("0~3 사이의 값은 정지한다.")
    @ParameterizedTest
    @CsvSource(value = {"0:false", "3:false"}, delimiter = ':')
    void isMovable_stopValue_returnFalse(int number, boolean expected) {
        assertThat(new RandomNumber(number).isMovable()).isEqualTo(expected);
    }

    @DisplayName("4~9 사이의 값은 전진한다.")
    @ParameterizedTest
    @CsvSource(value = {"4:true", "9:true"}, delimiter = ':')
    void isMovable_goValue_returnTrue(int number, boolean expected) {
        assertThat(new RandomNumber(number).isMovable()).isEqualTo(expected);
    }
}
