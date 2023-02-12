package domain;

import exception.CarNameLengthException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class CarTest {
    Car car1;
    @BeforeEach
    void setUp() {
        car1 = new Car("car1");
    }

    @Nested
    @DisplayName("전진과 멈춤에 대한 테스트")
    class Move {
        @Test
        @DisplayName("move의 입력값이 4로 전진한 경우")
        void case1() {
            car1.move(4);

            assertThat(car1.getPosition()).isEqualTo(1);
        }

        @Test
        @DisplayName("move의 입력값이 3으로 전진하지 않은 경우")
        void case2() {
            car1.move(3);

            assertThat(car1.getPosition()).isEqualTo(0);
        }
    }


    @Test
    @DisplayName("자동차의 이름이 길면 예외를 던짐")
    void validateCarName() {
        assertThatThrownBy(() -> new Car("long_car_name")).isInstanceOf(CarNameLengthException.class);
    }
}