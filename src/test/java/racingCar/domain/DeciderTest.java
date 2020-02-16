package racingCar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
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

    @ParameterizedTest
    @CsvSource(value = {"5,4,true", "1,9,false", "4,4,false"})
    void isBiggerThan(int given, int input, boolean expected) {
        // given
        Decider decider = new Decider(given);

        // when
        boolean bool = decider.isBiggerThan(input);

        // then
        Assertions.assertThat(bool).isEqualTo(expected);
    }
}
