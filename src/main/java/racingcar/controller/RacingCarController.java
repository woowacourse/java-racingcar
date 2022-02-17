package racingcar.controller;

import racingcar.domain.ParticipatedCars;
import racingcar.util.StringUtil;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {

    public void playGame() {
        ParticipatedCars participatedCars = new ParticipatedCars();
        participatedCars.generateCars(StringUtil.getCarNames(InputView.inputCarNames()));
        int trialCount = StringUtil.getTrialCount(InputView.inputTrials());

        executeRacingAndPrintRecord(trialCount, participatedCars);
        OutputView.printWinnerNames(participatedCars.findWinners());
    }

    private void executeRacingAndPrintRecord(int trialCount, ParticipatedCars participatedCars) {
        OutputView.printResultMessage();
        for (int i = 0; i < trialCount; i++) {
            participatedCars.executeCarRacing();
            OutputView.printRacingRecords(participatedCars);
        }
    }
}
