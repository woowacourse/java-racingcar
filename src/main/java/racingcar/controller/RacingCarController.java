package racingcar.controller;

import java.util.Arrays;
import java.util.List;

import racingcar.domain.ParticipateCars;
import racingcar.domain.WinnerNames;
import racingcar.validator.CarNameValidator;
import racingcar.validator.TrialCountValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {
    private static final String CAR_NAME_DELIMITER = ",";
    private static final int SPLIT_WITH_EMPTY = -1;

    public final ParticipateCars participateCars = new ParticipateCars();

    public void playGame() {
        participateCars.generateCars(getCarNames(InputView.inputCarNames()));
        int trialCount = getTrialCount(InputView.inputTrials());

        executeRacingUntil(trialCount);
        OutputView.printWinnerNames(participateCars.findWinners());
    }

    private void executeRacingUntil(int trialCount) {
        OutputView.printResultMessage();
        for (int i = 0; i < trialCount; i++) {
            OutputView.printRacingRecords(participateCars.executeCarRacing());
        }
    }

    public List<String> getCarNames(String carNamesLine) {
        CarNameValidator.checkCarNamesLine(carNamesLine);
        return split(carNamesLine);
    }

    private List<String> split(String carNamesLine) {
        List<String> carNames = Arrays.asList(carNamesLine.split(CAR_NAME_DELIMITER, SPLIT_WITH_EMPTY));
        CarNameValidator.checkCarNames(carNames);
        return carNames;
    }

    public int getTrialCount(String line) {
        TrialCountValidator.checkTrialCountLine(line);
        return Integer.parseInt(line);
    }
}
