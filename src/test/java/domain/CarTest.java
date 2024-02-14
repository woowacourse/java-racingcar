package domain;

import domain.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CarTest {
    @DisplayName("자동차 생성 성공 테스트")
    @Test
    void carGenerateTest() {
        assertThatCode(() -> new Car("테스트")).doesNotThrowAnyException();
    }

    @DisplayName("자동차 이름 5자 초과 예외 테스트")
    @Test
    void validateCarNameLengthTest() {
        assertThatThrownBy(() -> new Car("실패하는테스트")).isInstanceOf(IllegalArgumentException.class);
    }

}