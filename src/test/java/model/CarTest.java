package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @DisplayName("자동차 이름 유효성 검사")
    @Test
    void validateName() {
        assertThatThrownBy(() -> Car.validateName("nameOver5Length"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
