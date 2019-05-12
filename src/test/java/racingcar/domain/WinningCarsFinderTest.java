package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class WinningCarsFinderTest {
    WinningCarsFinder winningCarsFinder;

    @Test
    void 우승자_찾기() {
        Car car1 = new Car("pobi", 5);
        Car car2 = new Car("brown", 4);
        Car car3 = new Car("jun", 3);
        Car car4 = new Car("jason", 2);
        Car[] initialCars = {car1, car2, car3, car4};
        List<Car> cars = Arrays.asList(initialCars);

        winningCarsFinder = new WinningCarsFinder(cars);
        assertThat(winningCarsFinder.getWinningCars().get(0)).isEqualTo(new Car("pobi", 5));
    }

    @Test
    void 우승자가_여러명인_경우() {
        Car car1 = new Car("pobi", 5);
        Car car2 = new Car("brown", 5);
        Car car3 = new Car("jun", 3);
        Car car4 = new Car("jason", 2);
        Car[] initialCars = {car1, car2, car3, car4};
        List<Car> cars = Arrays.asList(initialCars);
        
        winningCarsFinder = new WinningCarsFinder(cars);
        assertThat(winningCarsFinder.getWinningCars().get(0)).isEqualTo(new Car("pobi", 5));
        assertThat(winningCarsFinder.getWinningCars().get(1)).isEqualTo(new Car("brown", 5));
    }
}
