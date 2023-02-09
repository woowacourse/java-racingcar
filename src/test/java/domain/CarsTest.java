package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {
    @DisplayName("더 많이 움직인 자동차가 우승자가 된다.")
    @Test
    public void test1() {
        Car car1 = new Car(new Name("k7"));
        Car car2 = new Car(new Name("audi"));

        Cars cars = new Cars(Arrays.asList(car1, car2));

        moveByCount(car1, 5);
        moveByCount(car2, 7);

        assertThat(cars.getWinners())
                .containsExactly(car2);
    }

    @DisplayName("많이 움직인 자동차가 2개 이상인 경우 공동 우승자가 된다.")
    @Test
    public void test2() {
        Car car1 = new Car(new Name("k7"));
        Car car2 = new Car(new Name("audi"));
        Car car3 = new Car(new Name("bmw"));


        Cars cars = new Cars(Arrays.asList(car1, car2, car3));

        moveByCount(car1, 5);
        moveByCount(car2, 7);
        moveByCount(car3, 7);

        assertThat(cars.getWinners())
                .containsExactly(car2, car3);
    }

    public void moveByCount(Car car, int count) {
        for (int i = 0; i < count; i++) {
            car.move(true);
        }
    }

}