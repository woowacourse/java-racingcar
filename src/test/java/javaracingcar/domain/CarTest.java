package javaracingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CarTest {

    @Nested
    @DisplayName("자동차 이름 입력 테스트")
    class CarNames {
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

    @Nested
    @DisplayName("자동차 이동 테스트")
    class CarMove {
        @Test
        @DisplayName("자동차 이동 성공 : 4 이상 값 입력 ")
        void move_ValueAboveFour_Move() {
            Car car = Car.generateCar("Benz");
            assertEquals(car.getPosition(), 0);
            car.move(5);
            assertEquals(car.getPosition(), 1);
        }

        @Test
        @DisplayName("자동차 이동 실패 : 3 이하 값 입력 ")
        void move_ValueBelowFour_Stop() {
            Car car = Car.generateCar("Benz");
            assertEquals(car.getPosition(), 0);
            car.move(3);
            assertEquals(car.getPosition(), 0);
        }
    }
}