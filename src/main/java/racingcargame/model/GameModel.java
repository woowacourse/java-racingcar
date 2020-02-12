package racingcargame.model;

import racingcargame.domain.Car;
import racingcargame.game.CarRace;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameModel {

    public static CarRace generateCarRace(String carNames) {
        List<String> names = Arrays.asList(carNames.split(","));
        List<Car> cars = names.stream().map(Car::new).collect(Collectors.toList());
        return new CarRace(cars);
    }
}
