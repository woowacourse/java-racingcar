package racingcargame.model;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class RacingCarGame {
    private static final int WINNER_POSITION = 0;

    private final CarGameRaceCount raceCount;
    private CarRepository carRepository;

    public RacingCarGame(List<String> carNames, int raceCount) {
        this.raceCount = Objects.requireNonNull(orderToSaveRaceCount(raceCount));
        orderToSaveCars(carNames);
    }

    private void orderToSaveCars(List<String> carNames) {
        carRepository = new CarRepository(carNames);
    }

    private CarGameRaceCount orderToSaveRaceCount(int count) {
        return new CarGameRaceCount(count);
    }

    public void orderToReduceRaceCount() {
        raceCount.reduceRaceCount();
    }

    public boolean isOverRace() {
        return raceCount.isZeroRaceCount();
    }

    public List<CarVO> startRace() {
        orderToReduceRaceCount();
        carRepository.moveCars();

        return carRepository.getCars()
                .stream()
                .map(CarVO::new)
                .collect(Collectors.toList());
    }

    public List<String> findRacingGameWinner() {
        List<Car> cars = carRepository.getCars();
        cars.sort(Collections.reverseOrder());

        return cars.stream()
                .filter(car -> car.isWinner(cars.get(WINNER_POSITION)))
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
