package racingCar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class DeciderTest {
    @ParameterizedTest
    @ValueSource(ints = {0,5,9})
    void Decider(int input) {
        // when
        Decider decider = new Decider(input);

        // then
        Assertions.assertThat(decider.getValue())
                .isEqualTo(input);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 10, -5, 15})
    void Decider_ShouldThrowException(int input) {
        // then
        Assertions.assertThatThrownBy(() -> {
            Decider decider = new Decider(input);
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    void isBiggerThan() {
        // given
        int value = 5;
        Decider decider = new Decider(value);

        // when
        int input = 4;
        boolean bool = decider.isBiggerThan(input);

        // then
        boolean expected = true;
        Assertions.assertThat(bool).isEqualTo(expected);
    }

    @Test
    void setValue() {
        // given
        Decider decider = new Decider(3);

        // when
        decider.setValue(9);

        // then
        Assertions.assertThat(decider.getValue())
                .isEqualTo(9);
    }

    @Test
    void setValue_ShouldThrowException() {
        // given
        Decider decider = new Decider(3);

        Assertions.assertThatThrownBy(() -> {

            // when
            decider.setValue(10);
        });
    }
}
