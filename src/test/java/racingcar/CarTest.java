package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    void 맥스값을_찾는다() {
        Car testCar = new Car("abc");
        assertThat(testCar.findMax(101)).isEqualTo(101);
    }

    @Test
    void 공백이_있는지_확인() {
        assertThat(Car.isWhiteSpaceOnly("")).isEqualTo(true);
    }

    @Test
    void 이름의_크기가_5글자가_넘는지_확인() {
        assertThat(Car.isOverLimit("aaaaaa")).isEqualTo(true);
    }

    @Test
    void 자동차가_잘_움직이는지_확인() {
        Car car = new Car("abc");
        Car checkCar = new Car("abc", 1);
        assertThat(car.moveCar(4)).isEqualTo(checkCar);
    }

    @Test
    void 자동차가_안움직이는_경우를_확인() {
        Car car = new Car("abc");
        Car checkCar = new Car("abc", 0);
        assertThat(car.moveCar(3)).isEqualTo(checkCar);
    }

    @Test
    void 자동차의_상태를_문자로_반환() {
        Car testCar = new Car("abc", 3);
        assertThat(testCar).isEqualTo(new Car("abc", 3));
    }
}
