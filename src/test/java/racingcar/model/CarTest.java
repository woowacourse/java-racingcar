package racingcar.model;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {

    private static Car car;

    @BeforeEach
    void init() {
        car = new Car("carA");
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @DisplayName("자동차 전진 테스트")
    void move(int number) {
        car.moveForward(number);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    @DisplayName("자동차 멈춤 테스트")
    void notMove(int number) {
        car.moveForward(number);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("Car 객체 내림차순 정렬 테스트")
    void sort_cars() {
        Car roseCar = new Car("rose", 1);
        Car lisaCar = new Car("lisa", 3);
        List<Car> cars = Arrays.asList(roseCar, lisaCar);

        Collections.sort(cars);
        assertThat(cars).containsExactly(lisaCar, roseCar);
    }
}
