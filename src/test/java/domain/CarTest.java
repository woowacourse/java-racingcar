package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class CarTest {

    @DisplayName("가장 멀리간 사람이 우승한다.")
    @Test
    void test1() {
        Car car1 = new Car(Name.of("hello"), Position.of(3));
        Car car2 = new Car(Name.of("world"), Position.of(4));

        Cars cars = new Cars(List.of(car1, car2));

        assertThat(cars.getWinners())
                .containsExactly(car2);
    }

    @DisplayName("가장 멀리 간 사람이 여러 명일 경우, 여러 명이 우승한다.")
    @Test
    void test2() {
        Car car1 = new Car(Name.of("hello"), Position.of(4));
        Car car2 = new Car(Name.of("world"), Position.of(4));

        Cars cars = new Cars(List.of(car1, car2));

        assertThat(cars.getWinners())
                .containsExactly(car1, car2);
    }
}
