package racingcargame.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    void 자동차가_움직이는지_테스트() {
        Car testCar = new Car("a", 10);
        Car newCar = testCar.update(5);
        assertThat(newCar).isEqualTo(new Car("a", 11));
    }

    @Test
    void 자동차가_움직이지않는지_테스트() {
        Car testCar = new Car("a", 10);
        Car newCar = testCar.update(3);
        assertThat(newCar).isEqualTo(new Car("a", 10));
    }
}

