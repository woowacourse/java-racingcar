package racingcar.controller;

import racingcar.model.Cars;
import racingcar.model.RacingGame;
import racingcar.view.OutputView;

public class RaceController {

    public void race(RacingGame racingGame) {
        OutputView.printResultPrefix();
        for (int i = 0; i < racingGame.getTryCount(); i++) {
            racingGame.raceRound();
            OutputView.printPosition(racingGame.getCars());
        }
        OutputView.printWinner(racingGame.getCars());
    }

    public Cars initCars(final String[] carNames) {
        return new Cars(carNames);
    }
}
