package racingcar.domain;

import racingcar.domain.vo.CarStatus;
import racingcar.util.NumberGenerator;
import racingcar.util.RaceNumberGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static racingcar.enumType.ExceptionMessage.RANGE_MESSAGE;


public class Race {

    private static final int RACE_MIN_TRY_COUNT = 0;

    private int tryCount;
    private final Cars cars;
    private final NumberGenerator numberGenerator;

    private Race(List<String> carNames, int tryCount) {
        validateRange(tryCount);
        this.tryCount = tryCount;
        this.cars = Cars.of(carNames);
        this.numberGenerator = new RaceNumberGenerator();
    }

    public static Race of(List<String> carNames, int tryCount) {
        return new Race(carNames, tryCount);
    }

    public List<CarStatus> setUpGame() {
        return cars.getRoundResults();
    }

    public List<CarStatus> playRound() {
        cars.move(setUpRound());
        return cars.getRoundResults();
    }

    public List<String> findWinnersName() {
        return cars.pickWinners().stream()
                .map(car -> car.getCarStatus().getName())
                .collect(Collectors.toList());
    }

    public int getTryCount() {
        return tryCount;
    }

    private List<Integer> setUpRound() {
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
