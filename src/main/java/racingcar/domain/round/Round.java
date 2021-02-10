package racingcar.domain.round;

import racingcar.domain.car.Cars;
import racingcar.domain.result.Result;
import racingcar.domain.result.Results;
import racingcar.utils.RandomNumbersUtils;
import racingcar.validator.RoundValidator;

import java.util.ArrayList;
import java.util.List;

public class Round {

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
        for (int i = 0 ; i < count; i++) {
            cars.tryToMoveCars(RandomNumbersUtils.createRandomNumbers(cars.size()));
            Result result = cars.getResultOfCars();
            results.add(result);
        }
        return Results.of(results);
    }

    public int getCount() {
        return this.count;
    }
}
