package racingcar.controller;

import java.util.List;
import racingcar.domain.CarNameValidator;
import racingcar.domain.Cars;
import racingcar.domain.RacingRecordDTO;
import racingcar.domain.WinnerNames;
import racingcar.util.BoundedRandomNumberGenerator;
import racingcar.util.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {
    private static final int MAX_BOUND = 9;
    private static final int MIN_BOUND = 0;

    public final RandomNumberGenerator randomNumberGenerator;

    public RacingCarController() {
        this.randomNumberGenerator = new BoundedRandomNumberGenerator(MAX_BOUND, MIN_BOUND);
    }

    public void playGame() {
        Cars cars = new Cars(validateCarNames(InputView.getCarNames()));
        int trialCount = InputView.getTrialCount();

        OutputView.printRacingRecordsMsg();
        for (int i = 0; i < trialCount; i++) {
            cars.executeCarRacing(randomNumberGenerator);
            OutputView.printRacingRecords(new RacingRecordDTO(cars.getRacingRecord()));
        }

        OutputView.printWinnerNames(new WinnerNames().findWinners(cars.getCars()));
    }

    private List<String> validateCarNames(List<String> carNames) {
        try {
            CarNameValidator.checkEachCarNames(carNames);
        } catch (RuntimeException exception) {
            System.out.println("[ERROR] " + exception.getMessage() + "\n");
            return validateCarNames(InputView.getCarNames());
        }

        return carNames;
    }
}
