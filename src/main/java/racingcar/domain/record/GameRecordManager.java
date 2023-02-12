package racingcar.domain.record;

import racingcar.domain.car.Car;
import racingcar.domain.cars.Cars;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class GameRecordManager {

    public Set<GameResultOfCar> makeGameResultsOfCars(int gameRound, Cars cars) {
        return cars.getCars()
                .stream()
                .map(car -> createGameResultOfCar(gameRound, car))
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    private GameResultOfCar createGameResultOfCar(int gameRound, Car car) {
        return new GameResultOfCar(gameRound, car.getName(), car.getPosition());
    }
}
