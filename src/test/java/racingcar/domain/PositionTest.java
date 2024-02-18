package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {
    private Position position;

    @BeforeEach
    void setUp() {
        position = new Position(1);
    }

    @Test
    @DisplayName("위치 값을 증가시킬 수 있다.")
    void increase() {
        position.increase();

        assertThat(position).extracting("position")
                .isEqualTo(2);
    }

    @ParameterizedTest
    @CsvSource(value = {"1, true", "0, false"})
    @DisplayName("입력된 위치와 자동차의 위치가 일치하는지 판별할 수 있다.")
    void isMatchPosition(int pos, boolean expected) {
        boolean actual = position.isMatchPosition(pos);
        assertThat(actual).isEqualTo(expected);
    }
}
