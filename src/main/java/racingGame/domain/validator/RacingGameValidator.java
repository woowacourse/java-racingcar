package racingGame.domain.validator;

import javafx.beans.binding.ObjectExpression;
import racingGame.domain.game.Rounds;
import racingGame.domain.racingCar.Cars;

import java.util.Objects;

public class RacingGameValidator {

    private static final int MINIMUM_CARS_TO_PLAY = 2;
    private static final int MINIMUM_ROUNDS_TO_PLAY = 1;

    private RacingGameValidator() {
    }

    public static void checkIsValidGame(final Cars cars, final Rounds round) {
        checkIsNull(cars);
        checkIsNull(round);

        checkCarsSize(cars);
        checkRoundValue(round);
    }

    private static void checkIsNull(final Object object) {
        if (Objects.isNull(object)) {
            throw new IllegalArgumentException("Arguments can't be null");
        }
    }

    private static void checkCarsSize(final Cars cars) {
        if (cars.size() < MINIMUM_CARS_TO_PLAY) {
            throw new IllegalArgumentException("There must be at least 2 cars to play");
        }
    }

    private static void checkRoundValue(final Rounds round) {
        if (!round.isMoreThan(MINIMUM_ROUNDS_TO_PLAY)) {
            throw new IllegalArgumentException("The number of rounds must be at least 1");
        }
    }
}
