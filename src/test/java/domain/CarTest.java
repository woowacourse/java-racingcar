package domain;

import exception.CarNameLengthException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.*;

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


    @Nested
    @DisplayName("자동차 이름의 길이에 대한 테스트")
    class ValidateCarName {
        @Test
        @DisplayName("길이가 6이상이면 예외를 던짐")
        void case1() {
            assertThatThrownBy(() -> new Car("666666")).isInstanceOf(CarNameLengthException.class);
        }

        @Test
        @DisplayName("길이가 5이하이면 정상 실행")
        void case2() {
            assertThatCode(() -> new Car("55555")).doesNotThrowAnyException();
            assertThatNoException().isThrownBy(() -> new Car("55555"));
        }
    }

}