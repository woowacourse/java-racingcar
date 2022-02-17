package racingcar.controller;

import racingcar.domain.ParticipatedCars;
import racingcar.util.StringUtil;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {

    private final ParticipatedCars participatedCars = new ParticipatedCars();

    public void playGame() {
        participatedCars.generateCars(StringUtil.getCarNames(InputView.inputCarNames()));
        int trialCount = StringUtil.getTrialCount(InputView.inputTrials());

        executeRacingAndPrintRecord(trialCount);
        OutputView.printWinnerNames(participatedCars.findWinners());
    }

    private void executeRacingAndPrintRecord(int trialCount) {
        OutputView.printResultMessage();
        for (int i = 0; i < trialCount; i++) {
            participatedCars.executeCarRacing();
            OutputView.printRacingRecords(participatedCars);
        }
    }
}
