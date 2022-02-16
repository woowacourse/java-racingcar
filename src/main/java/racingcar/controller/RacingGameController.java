package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.RacingGame;
import racingcar.domain.RacingRecord;
import racingcar.domain.RandomNumberGeneratePolicy;
import racingcar.domain.Round;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {
    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame(
            Cars.fromNames(InputView.getCarsName()),
            Round.fromNumber(InputView.getRound()),
            new RandomNumberGeneratePolicy());

        OutputView.printRacingRecordHeadLine();
        while (racingGame.isFinished()) {
            RacingRecord racingRecord = racingGame.race();
            OutputView.printRacingRecord(racingRecord);
        }
        OutputView.printRacingResult(racingGame.getRacingResult());
    }
}
