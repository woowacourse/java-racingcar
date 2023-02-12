package racingcar.domain;

import racingcar.domain.vo.CarStatus;
import racingcar.util.NumberGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static racingcar.enumType.ExceptionMessage.RANGE_MESSAGE;


public class Race {

    private static final int RACE_MIN_TRY_COUNT = 0;

    private int tryCount;
    private final Cars cars;

    private Race(Cars cars, int tryCount) {
        validateRange(tryCount);
        this.tryCount = tryCount;
        this.cars = cars;
    }

    public static Race of(Cars cars, int tryCount) {
        return new Race(cars, tryCount);
    }

    public List<CarStatus> playRound(NumberGenerator numberGenerator) {
        cars.move(numberGenerator);
        return cars.getRoundResults();
    }

    public List<String> findWinnersName() {
        return cars.pickWinners().stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public List<CarStatus> getRoundResults() {
        return cars.getRoundResults();
    }

    public int getTryCount() {
        return tryCount;
    }

    private List<Integer> setUpRound(NumberGenerator numberGenerator) {
        List<Integer> moveConditionValues = new ArrayList<>();
        for (int i = 0; i < cars.getNumberOfCars(); i++) {
            moveConditionValues.add(numberGenerator.generate());
        }
        return moveConditionValues;
    }

    private void validateRange(int tryCount) {
        if (tryCount <= RACE_MIN_TRY_COUNT) {
            throw new IllegalArgumentException(RANGE_MESSAGE.getValue());
        }
    }
}
