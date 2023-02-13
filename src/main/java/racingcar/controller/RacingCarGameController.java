package racingcar.controller;

import java.util.List;
import racingcar.domain.AdvanceJudgement;
import racingcar.domain.NumberGenerator.RandomNumberGenerator;
import racingcar.domain.RacingCarGame;
import racingcar.domain.RacingCars;
import racingcar.utils.CarNameParser;
import racingcar.validator.CarNamesValidator;
import racingcar.validator.TryCountValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarGameController {
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();

    public void run() {
        RacingCarGame racingCarGame = generateRacingCarGame();
        int tryCount = getTryCount(inputView.readTryCount());
        outputView.printResultHeader();
        outputView.printRoundResult(racingCarGame.getCurrentState());
        for (int roundCount = 0; roundCount < tryCount; roundCount++) {
            outputView.printRoundResult(racingCarGame.runRound());
        }
        outputView.printWinners(racingCarGame.getWinnerNames());
    }

    private RacingCarGame generateRacingCarGame() {
        return new RacingCarGame(generateAdvanceJudgement(), generateRacingCarsByNames(getCarNames()));
    }

    private AdvanceJudgement generateAdvanceJudgement() {
        return new AdvanceJudgement(new RandomNumberGenerator());
    }

    private RacingCars generateRacingCarsByNames(List<String> carNames) {
        return RacingCars.generateByNames(carNames);
    }

    private List<String> getCarNames() {
        String carNames = inputView.readCarName();
        List<String> parsedNames = CarNameParser.parsing(carNames);
        if (isValidCarNames(parsedNames)) {
            return parsedNames;
        }
        return getCarNames();
    }

    private boolean isValidCarNames(List<String> carNames) {
        CarNamesValidator carNamesValidator = new CarNamesValidator();
        try {
            carNamesValidator.validateNames(carNames);
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception.getMessage());
            return false;
        }
        return true;
    }

    private int getTryCount(String tryCount) {
        if (isValidTryCount(tryCount)) {
            return Integer.parseInt(tryCount);
        }
        tryCount = inputView.readTryCount();
        return getTryCount(tryCount);
    }

    private boolean isValidTryCount(String tryCount) {
        TryCountValidator tryCountValidator = new TryCountValidator();
        try {
            tryCountValidator.validateTryCount(tryCount);
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception.getMessage());
            return false;
        }
        return true;
    }
}
