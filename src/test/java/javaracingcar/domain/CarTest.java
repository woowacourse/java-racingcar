package javaracingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CarTest {
    @Test
    @DisplayName("자동차 이름 입력 실패: Null")
    void generateCar_Null_ExceptionThrown() {
        assertThatThrownBy(() -> Car.generateCar(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("null");
    }

    @Test
    @DisplayName("자동차 이름 입력 실패: 공백 문자열")
    void generateCar_BlankInput_ExceptionThrown() {
        assertThatThrownBy(() -> Car.generateCar(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("빈 문자열");
        assertThatThrownBy(() -> Car.generateCar("   "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("빈 문자열");
    }

    @Test
    @DisplayName("자동차 이름 입력 실패: 5자 초과 자동차 이름")
    void generateCar_LengthMoreOrEqualsToFive_False() {
        assertThatThrownBy(() -> Car.generateCar("Tuscan"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("최대길이를 초과");
    }

    @Test
    @DisplayName("자동차 이름 입력 성공: 5자 이하 자동차 이름")
    void generateCar_LengthLessThanFive_True() {
        Car car = Car.generateCar("Benz");
        assertEquals(car.getName(), "Benz");
    }
}