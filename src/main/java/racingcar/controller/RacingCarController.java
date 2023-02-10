package racingcar.controller;

import racingcar.common.log.Logger;
import racingcar.domain.car.Cars;
import racingcar.domain.game.*;
import racingcar.view.InputView;
import racingcar.view.OutputView;

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

    public void gameStart(Retry retry) {
        do {
            retry = runWithExceptionHandle(retry);
        } while (retry.retryable());
        Logger.error("프로그램을 종료합니다.");
    }

    private Retry runWithExceptionHandle(Retry retry) {
        try {
            gameSteps().run();
            retry = Retry.NO_RETRY;
        } catch (IllegalArgumentException e) {
            Logger.error(e.getMessage());
            retry = retry.retry();
        }
        return retry;
    }

    private Runnable gameSteps() {
        return () -> {
            Cars cars = createCars();
            Lap lap = confirmTotalLap();
            RacingCarGame game = RacingCarGame.init(generator, winnerJudge, cars, lap);
            OutputView.printResultMessage();
            runRace(game);
        };
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
}
