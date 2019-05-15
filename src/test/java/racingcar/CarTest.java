package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    void compareTest() {
        Car testCar = new Car("abc");
        assertThat(testCar.findMax(101)).isEqualTo(101);
    }

    @Test
    void isWhiteSpaceOnlyTest() {
        assertThat(Car.isWhiteSpaceOnly("")).isEqualTo(true);
    }

    @Test
    void isOverLimitTest() {
        assertThat(Car.isOverLimit("aaaaaa")).isEqualTo(true);
    }

    @Test
    void moveCarTest() {
        Car car = new Car("abc");
        Car checkCar = new Car("abc", 1);
        assertThat(car.moveCar(4)).isEqualTo(checkCar);
    }

    @Test
    void notMoveCarTest() {
        Car car = new Car("abc");
        Car checkCar = new Car("abc", 0);
        assertThat(car.moveCar(3)).isEqualTo(checkCar);
    }

    @Test
    void getCarStateTest() {
        String checkString = "abc : ---";
        Car testCar = new Car("abc", 3);
        assertThat(testCar.getCarState()).isEqualTo(checkString);
    }
}
