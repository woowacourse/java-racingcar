package racingcar.controller;

import racingcar.domain.car.Cars;
import racingcar.domain.game.*;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.Arrays;

import static java.util.stream.Collectors.toUnmodifiableList;

public class RacingCarController {

    private static final String DELIMITER = ",";
    private final NumberGenerator generator;
    private final WinnerJudge winnerJudge;

    public RacingCarController(final NumberGenerator generator, final WinnerJudge winnerJudge) {
        this.generator = generator;
        this.winnerJudge = winnerJudge;
    }

    public void gameStart() {
        Cars cars = createCars();
        Lap lap = confirmTotalLap();
        RacingCarGame game = RacingCarGame.init(generator, winnerJudge, cars, lap);

        OutputView.printResultMessage();
        runRace(game);
    }

    private Cars createCars() {
        String carNames = InputView.inputCarNames();
        return new Cars(Arrays.stream(carNames.split(DELIMITER))
                .collect(toUnmodifiableList()));
    }

    private Lap confirmTotalLap() {
        return new Lap(InputView.inputTotalLap());
    }

    private void runRace(final RacingCarGame game) {
        while (game.hasMoreLap()) {
            MovedResult movedResult = game.race();
            OutputView.printState(movedResult);
        }
        GameResult gameResult = game.gameResult();
        OutputView.printWinners(gameResult);
    }
}
