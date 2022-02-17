package racingcargame.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGame {
    private static final String RACE_COUNT_START_ZERO_ERROR_MESSAGE = "[error] 경주횟수는 1이상의 값을 입력해주세요.";
    private static final String ERROR_CAR_NAME_IS_SIZE_EXCEED_THAN_MAX = "[error] 자동차 이름을 1자이상, 5자 이하로 입력해주세요.";
    private static final String ERROR_SAME_CAR_NAME = "[error] 중복된 자동차 이름이 있습니다.";
    private static final int ZERO_EXIST = 0;
    private static final int CAR_NAME_MAX_SIZE = 5;
    private static final int WINNER_POSITION = 0;
    private static final String COUNT_IS_ZERO = "0";
    private static final String CAR_NAME_DELIMITER = ",";

    private final RaceCount raceCount;
    private Cars carRepository;

    public RacingCarGame(String carNames, String raceCount) {
        validateRaceCount(raceCount);
        validateCarNames(carNames);
        this.raceCount = orderToSaveRaceCount(makeIntegerRaceCount(raceCount));
        this.carRepository = orderToSaveCars(makeSplitCarNames(carNames));
    }

    private void validateRaceCount(String raceCount) {
        if (raceCount.startsWith(COUNT_IS_ZERO)) {
            throw new IllegalArgumentException(RACE_COUNT_START_ZERO_ERROR_MESSAGE);
        }
    }

    private void validateCarNames(String carNames) {
        checkOverCarNamesLimitSize(carNames);
        checkSameCarNames(carNames);
    }

    private static void checkOverCarNamesLimitSize(String carNames) {
        String[] cars = carNames.split(CAR_NAME_DELIMITER);
        long count = Arrays.stream(cars)
                .filter(car -> car.length() > CAR_NAME_MAX_SIZE)
                .count();

        if (count > ZERO_EXIST) {
            throw new IllegalArgumentException(ERROR_CAR_NAME_IS_SIZE_EXCEED_THAN_MAX);
        }
    }

    private static void checkSameCarNames(String carNames) {
        String[] cars = carNames.split(CAR_NAME_DELIMITER);
        long count = Arrays.stream(cars)
                .distinct()
                .count();

        if (count < cars.length) {
            throw new IllegalArgumentException(ERROR_SAME_CAR_NAME);
        }
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
