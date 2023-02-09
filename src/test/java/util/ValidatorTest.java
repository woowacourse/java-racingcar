package util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"a","0"})
    void validateMovingCountInput(String input) {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> Validator.validateMovingCountInput(input));
    }
}