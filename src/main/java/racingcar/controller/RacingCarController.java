package racingcar.controller;

import racingcar.domain.RacingCars;
import racingcar.domain.RacingGame;
import racingcar.domain.Round;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {

    private final InputView inputView;
    private final OutputView outputView;

    public RacingCarController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        final RacingCars racingCars = RacingCars.from(inputView.inputCarNames());
        final Round finalRound = new Round(inputView.inputTryCount());

        final RacingGame game = new RacingGame(racingCars, finalRound);
        outputView.printGameResultTitle();
        raceAllRound(game);
        outputView.printWinnerNames(game.winnerNames());
    }

    private void raceAllRound(final RacingGame game) {
        while (!game.isEnd()) {
            game.race();
            outputView.printCarsPosition(game.getCurrentRacingCarDtos());
        }
    }
}
