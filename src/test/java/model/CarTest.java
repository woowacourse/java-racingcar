package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("이름은 존재해야 한다.")
    void validateNullAndEmpty(String input) {
        assertThatThrownBy(() -> new Car(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("이름은 5자 이하만 가능하다.")
    void validateNameLength() {
        String name = "dddddd";
        assertThatThrownBy(() -> new Car(name)).isInstanceOf(IllegalArgumentException.class);
    }
}