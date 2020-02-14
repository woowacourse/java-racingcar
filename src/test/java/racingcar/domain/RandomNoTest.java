package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RandomNoTest {
    RandomNo no;

    @Test
    void throw_isValid_RandomNumber() {
        Assertions.assertThatCode(() ->
                no = new RandomNo(3)).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 10})
    void throw_isNotValid_RandomNumber(int value) {
        Assertions.assertThatThrownBy(() ->
                no = new RandomNo(value)).isInstanceOf(IllegalArgumentException.class);
    }
}