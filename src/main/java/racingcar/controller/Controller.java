package racingcar.controller;

import racingcar.model.Cars;
import racingcar.model.RaceRule;
import racingcar.model.RacingGame;
import racingcar.utils.Randoms;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Controller {

    private final InputView inputView;
    private final OutputView outputView;

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Cars cars = inputView.askCarNames();
        RacingGame racingGame = new RacingGame(cars);
        int moveCount = inputView.askMoveCount();
        RaceRule raceRule = () -> Randoms.pickNumberInRange() >= 4;
        outputView.printProgressGuide();
        while (moveCount-- > 0) {
            racingGame.move(raceRule);
            outputView.printProgress(cars);
        }
        Cars winners = racingGame.findWinners();
        outputView.printWinners(winners);
    }
}
