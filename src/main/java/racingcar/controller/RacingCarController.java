package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.Lap;

import java.util.Arrays;

import static java.util.stream.Collectors.toUnmodifiableList;

public class RacingCarController {

    private static final String DELIMITER = ",";

    public Cars createCars(final String carNames) {
        return new Cars(Arrays.stream(carNames.split(DELIMITER))
                .collect(toUnmodifiableList()));
    }

    public Lap confirmTotalLap(final int totalLap) {
        return new Lap(totalLap);
    }
}
