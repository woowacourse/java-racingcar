package racingGame.controller;

import org.junit.jupiter.api.Test;
import racingGame.domain.Car;
import racingGame.domain.Cars;
import racingGame.domain.Name;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {
    @Test
    void getWinners_우승한_자동차() {
        List<Car> inGameCars = new ArrayList<>();
        Cars cars;

        inGameCars.add(new Car(new Name("car1")));
        inGameCars.add(new Car(new Name("car2")));
        inGameCars.add(new Car(new Name("car3")));
        inGameCars.add(new Car(new Name("car4")));

        inGameCars.get(0).move(7);
        inGameCars.get(1).move(7);
        inGameCars.get(2).move(7);
        inGameCars.get(3).move(7);
        inGameCars.get(2).move(7);
        inGameCars.get(3).move(7);

        cars = new Cars(inGameCars);
        cars.updateMaximumPosition();
        List<Car> actual = cars.getWinnersList();

        List<Car> expected = Arrays.asList(
                new Car(new Name("car3")),
                new Car(new Name("car4")));

        assertThat(actual).isEqualTo(expected);
    }
}
