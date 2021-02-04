package racingcar;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;

import static org.assertj.core.api.Assertions.*;

public class CarNameTest {

    @ParameterizedTest
    @CsvSource(value = {"sdlfelsdkg"})
    void checkNameLength(String value) {
        assertThatThrownBy(() -> {
            CarName carName = new CarName(value);
        }).isInstanceOf(RuntimeException.class);
    }

    @ParameterizedTest
    @EmptySource
    void checkNameLength_empty(String value) {
        assertThatThrownBy(() -> {
            CarName carName = new CarName(value);
        }).isInstanceOf(RuntimeException.class);
    }

}
