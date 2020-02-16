package racingGame.controller;

import org.junit.jupiter.api.Test;
import racingGame.domain.Car;
import racingGame.domain.Cars;
import racingGame.domain.Name;
import racingGame.utils.FixedMovableStrategy;
import racingGame.utils.NumberGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {
    @Test
    void getWinners_우승한_자동차() {
        List<Car> inGameCars = new ArrayList<>();
        Cars cars;
        NumberGenerator numberGenerator = new NumberGenerator();
        numberGenerator.setNumberGenerateStrategy(new FixedMovableStrategy());

        inGameCars.add(new Car(new Name("car1")));
        inGameCars.add(new Car(new Name("car2")));
        inGameCars.add(new Car(new Name("car3")));
        inGameCars.add(new Car(new Name("car4")));

        inGameCars.get(0).move(numberGenerator.generate());
        inGameCars.get(1).move(numberGenerator.generate());
        inGameCars.get(2).move(numberGenerator.generate());
        inGameCars.get(3).move(numberGenerator.generate());
        inGameCars.get(2).move(numberGenerator.generate());
        inGameCars.get(3).move(numberGenerator.generate());

        cars = new Cars(inGameCars);
        List<Car> actual = cars.getWinnersList();

        List<Car> expected = Arrays.asList(
                new Car(new Name("car3")),
                new Car(new Name("car4")));

        assertThat(actual).isEqualTo(expected);
    }
}
