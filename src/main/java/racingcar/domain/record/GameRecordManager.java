package racingcar.domain.record;

import racingcar.domain.car.Car;
import racingcar.domain.cars.Cars;

import java.util.List;
import java.util.stream.Collectors;

public class GameRecordManager {

    public List<GameResultOfCar> makeGameResultsOfCars(int gameRound, Cars cars) {
        return cars.getCars()
                .stream()
                .map(car -> createGameResultOfCar(gameRound, car))
                .collect(Collectors.toUnmodifiableList());
    }

    private GameResultOfCar createGameResultOfCar(int gameRound, Car car) {
        return new GameResultOfCar(gameRound, car.getName(), car.getPosition());
    }
}
