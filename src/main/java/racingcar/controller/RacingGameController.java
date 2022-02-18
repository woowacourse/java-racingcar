package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.Names;
import racingcar.domain.RacingGame;
import racingcar.domain.RandomNumberGeneratePolicy;
import racingcar.domain.Round;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {
    public void startRacing() {
        RacingGame racingGame = RacingGame.createRacingGame(
                getCars(),
                getRound(),
                new RandomNumberGeneratePolicy()
        );
        OutputView.printRacingRecordHeadLine();
        while (racingGame.hasNextGame()) {
            OutputView.printRacingRecord(racingGame.race());
        }
        OutputView.printRacingResult(racingGame.findCarsOfWinner());
    }

    private Cars getCars() {
        try {
            return Cars.fromNames(Names.fromInput(InputView.getCarNames()));
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
            return getCars();
        }
    }

    private Round getRound() {
        try {
            return Round.fromInput(Integer.parseInt(InputView.getRound()));
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
            return getRound();
        }
    }
}
