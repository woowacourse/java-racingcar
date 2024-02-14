package racingcar.controller;

import racingcar.model.Cars;
import racingcar.model.Round;
import racingcar.view.InputView;

public class GameController {

    private final InputView inputView;

    public GameController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        String names = inputView.readCarNames();
        Cars cars = Cars.from(names);

        String tryRound = inputView.readTryRound();
        Round round = Round.from(tryRound);

//        cars.go(round);
    }

}
