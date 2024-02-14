package racing.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    @Test
    @DisplayName("정상적인 자동차 객체 생성")
    void createCar() {
        assertDoesNotThrow(()->new Car("pobi"));
    }

    @Test
    @DisplayName("자동차 이름이 5자 초과이면 예외")
    void createCarWithOverSize() {
        assertThatThrownBy(()->new Car("pobipobi"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}