package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.car.CarNames;
import racingcar.domain.car.Cars;
import racingcar.domain.numbergenerator.NumberGenerator;
import racingcar.domain.result.RoundResult;

public class RacingGame {

    private final Cars cars;
    private final Round round;

    public RacingGame(final Cars cars, final Round round) {
        this.cars = cars;
        this.round = round;
    }

    public static RacingGame of(final CarNames carNames, final Round round) {
        return new RacingGame(Cars.from(carNames), round);
    }

    public List<RoundResult> play(final NumberGenerator numberGenerator) {
        final List<RoundResult> roundResults = new ArrayList<>();

        while (round.isContinue()) {
            cars.go(numberGenerator);
            round.progress();

            final RoundResult roundResult = cars.getRoundResult();
            roundResults.add(roundResult);
        }

        return roundResults;
    }

    public List<String> getWinners() {
        return cars.findWinners();
    }
}
