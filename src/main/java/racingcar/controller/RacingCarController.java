package racingcar.controller;

import racingcar.domain.RacingCarCommander;
import racingcar.domain.RacingCars;
import racingcar.domain.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {

    private final InputView inputView;
    private final OutputView outputView;

    public RacingCarController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        RacingCars racingCars = new RacingCars(inputView.inputCarNames(), new RacingCarCommander());
        int tryCount = inputView.inputTryCount();

        RacingGame game = new RacingGame(racingCars, tryCount);
        outputView.printGameResultTitle();
        raceAllRounds(game, racingCars);
        outputView.printWinnerNames(game.getWinnerNames());
    }

    public void raceAllRounds(RacingGame game, RacingCars racingCars) {
        while (!game.isEnd()) {
            game.race();
            outputView.printCarsPosition(racingCars.getRacingCarDtoList());
        }
    }
}
