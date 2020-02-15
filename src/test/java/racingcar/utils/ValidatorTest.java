package racingcar.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"1", "3", "5"})
    void when_isValidPlayRound(String playRound) {
        Assertions.assertThatCode(() -> Validator.validatePlayRound(playRound)).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "-3", "-5"})
    void Throw_isNotValidPlayRound(String playRound) {
        Assertions.assertThatThrownBy(() -> Validator.validatePlayRound(playRound))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1.1", "-3.1", "5.2"})
    void Throw_isNotIntegerPlayRound(String playRound) {
        Assertions.assertThatThrownBy(() -> Validator.validatePlayRound(playRound))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
