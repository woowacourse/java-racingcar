package racingcar.domain;

import racingcar.utils.RandomUtils;
import racingcar.validator.RoundValidator;

import java.util.ArrayList;
import java.util.List;

public class Round {
    private static final int MIN_RANDOM_RANGE = 0;
    private static final int MAX_RANDOM_RANGE = 9;

    private final int count;

    private Round(final String inputCount) {
        this.count = Integer.parseInt(inputCount);
    }

    public static Round of(final String inputCount) {
        RoundValidator.validate(inputCount);
        return new Round(inputCount);
    }

    public Results startRace(Cars cars) {
        List<Result> results = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            cars.tryToMoveCars(createRandomNumbers(cars));
            Result result = cars.getResultOfCars();
            results.add(result);
        }
        return Results.of(results);
    }

    private List<Integer> createRandomNumbers(Cars cars) {
        List<Integer> randomNumbers = new ArrayList<>();
        for (int i = 0; i < cars.size(); i++) {
            randomNumbers.add(createRandomNumber());
        }
        return randomNumbers;
    }

    private int createRandomNumber() {
        return RandomUtils.nextInt(MIN_RANDOM_RANGE, MAX_RANDOM_RANGE);
    }

    public int getCount() {
        return this.count;
    }
}
