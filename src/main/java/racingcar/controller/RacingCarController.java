package racingcar.controller;

import racingcar.common.log.Logger;
import racingcar.domain.car.Cars;
import racingcar.domain.car.MovedResult;
import racingcar.domain.game.*;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.function.Supplier;

import static java.util.Arrays.stream;
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
        Cars cars = inputWithExceptionHandle(this::createCars);
        Lap lap = inputWithExceptionHandle(this::confirmTotalLap);
        RacingCarGame game = RacingCarGame.init(generator, winnerJudge, cars, lap);
        OutputView.printResultMessage();
        runRace(game);
    }

    private Cars createCars() {
        String carNames = InputView.inputCarNames();
        return new Cars(stream(carNames.split(DELIMITER))
                .collect(toUnmodifiableList()));
    }

    private Lap confirmTotalLap() {
        return Lap.totalLap(InputView.inputTotalLap());
    }

    private void runRace(final RacingCarGame game) {
        while (game.hasMoreLap()) {
            MovedResult movedResult = game.race();
            OutputView.printState(movedResult);
        }
        GameResult gameResult = game.gameResult();
        OutputView.printWinners(gameResult);
    }

    private static <T> T inputWithExceptionHandle(final Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                Logger.error(e.getMessage());
            }
        }
    }
}
