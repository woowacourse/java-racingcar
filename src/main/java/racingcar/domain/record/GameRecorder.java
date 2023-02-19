package racingcar.domain.record;

import racingcar.domain.car.Car;
import racingcar.domain.cars.Cars;
import racingcar.domain.result.GameResultOfCar;

import java.util.List;
import java.util.stream.Collectors;

public class GameRecorder {

    private final List<GameResultOfCar> records;

    public GameRecorder(final List<GameResultOfCar> records) {
        this.records = records;
    }

    public void record(final int gameRound, final Cars cars) {
        records.addAll(makeResults(gameRound, cars));
    }

    public List<GameResultOfCar> makeResults(final int gameRound, final Cars cars) {
        return cars.getCars()
                .stream()
                .map(car -> createGameResultOfCar(gameRound, car))
                .collect(Collectors.toUnmodifiableList());
    }

    private GameResultOfCar createGameResultOfCar(final int gameRound, final Car car) {
        return new GameResultOfCar(gameRound, car.getName(), car.getPosition());
    }

    public List<GameResultOfCar> getRecords() {
        return records;
    }
}
