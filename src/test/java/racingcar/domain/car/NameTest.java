package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exception.CarNameBlankException;

public class NameTest {

    @ParameterizedTest
    @ValueSource(strings ={""," ","    "})
    void CarNameIsNotBlank(String input) {
        assertThatExceptionOfType(CarNameBlankException.class)
            .isThrownBy(() -> new Name(input))
            .withMessageContaining(CarNameBlankException.ERROR_MESSAGE);
    }
}
