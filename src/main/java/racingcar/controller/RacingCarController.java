package racingcar.controller;

import racingcar.controller.response.MovedResultResponse;
import racingcar.domain.car.Cars;
import racingcar.domain.game.Lap;
import racingcar.domain.game.NumberGenerator;
import racingcar.domain.game.WinnerJudge;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toUnmodifiableList;

public class RacingCarController {

    private static final String DELIMITER = ",";
    private final NumberGenerator generator;
    private final WinnerJudge winnerJudge;

    public RacingCarController(final NumberGenerator generator, final WinnerJudge winnerJudge) {
        this.generator = generator;
        this.winnerJudge = winnerJudge;
    }

    public Cars createCars(final String carNames) {
        return new Cars(Arrays.stream(carNames.split(DELIMITER))
                .collect(toUnmodifiableList()));
    }

    public Lap confirmTotalLap(final int totalLap) {
        return new Lap(totalLap);
    }

    public MovedResultResponse moveCars(final Cars cars, final Lap lap) {
        cars.move(generator);
        lap.next();
        return new MovedResultResponse(cars);
    }

    public List<String> winners(final Cars cars) {
        return winnerJudge.judge(cars).stream()
                .map(it -> it.getName().getValue())
                .collect(Collectors.toList());
    }
}
