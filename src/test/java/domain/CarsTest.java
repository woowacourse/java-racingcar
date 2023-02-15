package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class CarsTest {

    @DisplayName("가장 멀리간 사람이 우승한다.")
    @ParameterizedTest
    @CsvSource({
            "0,1",
            "3,4",
            "100,101"
    })
    void test1(int position1, int position2) {
        Car car1 = new Car(Name.of("car1"), Position.of(position1));
        Car car2 = new Car(Name.of("car2"), Position.of(position2));

        Cars cars = new Cars(List.of(car1, car2));

        assertThat(cars.getWinners())
                .containsExactly(car2);
    }

    @DisplayName("가장 멀리 간 사람이 여러 명일 경우, 여러 명이 우승한다.")
    @ParameterizedTest
    @CsvSource({
            "0,0,0",
            "4,4,4",
            "100,100,100"
    })
    void test2(int position1, int position2, int position3) {
        Car car1 = new Car(Name.of("car1"), Position.of(position1));
        Car car2 = new Car(Name.of("car2"), Position.of(position2));
        Car car3 = new Car(Name.of("car3"), Position.of(position3));

        Cars cars = new Cars(List.of(car1, car2, car3));

        assertThat(cars.getWinners())
                .containsExactly(car1, car2, car3);
    }

    @DisplayName("MovingStrategy에서 ")
    @Nested
    class MovingStrategyTest {
        Car car1;
        Car car2;
        Cars cars;

        @BeforeEach
        void init() {
            car1 = new Car(Name.of("car1"), Position.create());
            car2 = new Car(Name.of("car2"), Position.create());
            cars = new Cars(List.of(car1, car2));
        }

        @DisplayName("false를 반환하면 차가 움직이지 않는다.")
        @Test
        void stopTest() {
            cars.moveCars(() -> false);
            assertThat(car1.getPosition()).isEqualTo(Position.of(0));
            assertThat(car2.getPosition()).isEqualTo(Position.of(0));
        }

        @DisplayName("true를 반환하면 차가 한 칸 움직인다.")
        @Test
        void moveTest() {
            cars.moveCars(() -> true);
            assertThat(car1.getPosition()).isEqualTo(Position.of(1));
            assertThat(car2.getPosition()).isEqualTo(Position.of(1));
        }
    }
}
