package model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class CarTest {

    @Nested
    @DisplayName("자동차 이동 테스트")
    class MoveTest {
        Car car;

        @BeforeEach
        void setUp() {
            car = new Car(new Name("호기"));
        }

        @Test
        @DisplayName("전진을 안 한 경우")
        void notMoveTest() {
            assertThat(car.showDistance()).isEqualTo("");
        }

        @Test
        @DisplayName("한 칸 전진")
        void moveOneTest() {
            car.move();

            assertThat(car.showDistance()).isEqualTo("-");
        }

        @Test
        @DisplayName("두 칸 전진")
        void moveTwoTest() {
            car.move();
            car.move();

            assertThat(car.showDistance()).isEqualTo("--");
        }
    }
}