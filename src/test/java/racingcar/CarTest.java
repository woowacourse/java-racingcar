package racingcar;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {
    @ParameterizedTest
    @ValueSource(strings = {"너무 긴 이름", ""})
    void carNameTest(String input) {
        assertThatThrownBy(() -> {
            new Car(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
