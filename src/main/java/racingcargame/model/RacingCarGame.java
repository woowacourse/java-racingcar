package racingcargame.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGame {
    private static final String CAR_NAME_DELIMITER = ",";
    private static final int WINNER_POSITION = 0;

    private final RaceCount raceCount;
    private Cars carRepository;

    public RacingCarGame(String carNames, String raceCount) {
        this.raceCount = orderToSaveRaceCount(makeIntegerRaceCount(raceCount));
        this.carRepository = orderToSaveCars(makeSplitCarNames(carNames));
    }

    private List<String> makeSplitCarNames(String carNames) {
        return List.of(carNames.split(CAR_NAME_DELIMITER));
    }

    private int makeIntegerRaceCount(String count) {
        return Integer.parseInt(count);
    }

    private Cars orderToSaveCars(List<String> carNames) {
        return new Cars(carNames);
    }

    private RaceCount orderToSaveRaceCount(int count) {
        return new RaceCount(count);
    }

    public void orderToReduceRaceCount() {
        raceCount.reduceCount();
    }

    public boolean isOverRace() {
        return raceCount.isZeroCount();
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
