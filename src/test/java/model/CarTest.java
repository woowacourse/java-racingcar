package model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.assertj.core.api.Assertions;
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

    @Nested
    @DisplayName("정렬 테스트")
    class SortCars {
        @Test
        @DisplayName("내림차순 정렬 테스트")
        void sortTest() {
            List<Car> cars = new ArrayList<>();
            Car car1 = new Car(new Name("호기"));
            Car car2 = new Car(new Name("재즈"));
            Car car3 = new Car(new Name("상돌"));
            Car car4 = new Car(new Name("아루"));
            cars.add(car1);
            cars.add(car2);
            cars.add(car3);
            cars.add(car4);

            car1.move();
            car1.move();
            car3.move();
            car4.move();
            car4.move();
            car4.move();

            Collections.sort(cars);

            Assertions.assertThat(cars.get(0)).isSameAs(car4);
        }

    }
}
