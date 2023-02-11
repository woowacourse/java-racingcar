package racingcar.controller;

import racingcar.common.log.Logger;
import racingcar.controller.response.MovedResult;
import racingcar.controller.response.WinnerResponse;
import racingcar.domain.car.Cars;
import racingcar.domain.game.Lap;
import racingcar.domain.game.NumberGenerator;
import racingcar.domain.game.RacingCarGame;
import racingcar.domain.game.Winners;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.function.Supplier;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toUnmodifiableList;

public class RacingCarController {

    private static final String DELIMITER = ",";

    private final NumberGenerator generator;

    public RacingCarController(final NumberGenerator generator) {
        this.generator = generator;
    }

    public void gameStart() {
        Cars cars = inputWithExceptionHandle(this::createCars);
        Lap lap = inputWithExceptionHandle(this::confirmTotalLap);
        RacingCarGame game = RacingCarGame.init(generator, cars, lap);
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
            game.race();
            OutputView.printState(new MovedResult(game.cars()));
        }
        Winners winners = game.winner();
        OutputView.printWinners(new WinnerResponse(winners.winners()));
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
