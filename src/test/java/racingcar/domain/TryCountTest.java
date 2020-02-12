/*
 * Copyright (c) 2020 by 티거, 제이미
 * All rights reserved.
 *
 * @author      티거, 제이미
 * @version     1.0
 * @date        12 Feb 2020
 *
 */

package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TryCountTest {

    @DisplayName("숫자인지 판단하는 테스트")
    @Test
    void validateNumber() {
        String input = "o";
        assertThatThrownBy(() -> new TryCount(input)).isInstanceOf(NumberFormatException.class)
            .hasMessageContaining("숫자");
    }

    @DisplayName("범위 판단하는 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "10001"})
    void validateRange(String input) {
        assertThatThrownBy(() -> new TryCount(input)).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("숫자");
    }


}
