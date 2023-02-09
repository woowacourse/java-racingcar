package racingcar.controller;

import racingcar.domain.*;
import racingcar.dto.RacingCarDto;
import racingcar.utils.Parser;
import racingcar.validator.CarNamesValidator;
import racingcar.validator.TryCountValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGameController {
    private static final int FIRST_CAR_INDEX = 0;
    private OutputView outputView = new OutputView();
    private InputView inputView = new InputView();


    public void run() {
        List<String> validateCarNames = getValidateCarNames();
        int tryCount = getValidTryCount();
        RoundManager roundManager = initializeRoundManager(validateCarNames);

        outputView.printResultHeader();
        outputView.printRoundResult(roundManager.getCurrentRound());
        for (int roundCount = 0; roundCount < tryCount; roundCount++) {
            outputView.printRoundResult(roundManager.runRound());
        }

        List<String> winningCarsName = getWinningCarsName(roundManager.getSortedRacingCars());
        outputView.printWinners(winningCarsName);
    }

    private List<String> getParsedCarNames() {
        String carNames = inputView.readCarName();
        return Parser.parsing(carNames, ",");
    }

    private List<String> getValidateCarNames() {
        List<String> parsedCarNames = new ArrayList<>();
        do {
            parsedCarNames = getParsedCarNames();
        } while (!isValidCarNames(parsedCarNames));
        return parsedCarNames;
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

    private int getValidTryCount() {
        String tryCount;
        do {
            tryCount = inputView.readTryCount();
        } while (!isValidTryCount(tryCount));
        return Integer.parseInt(tryCount);
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

    private void setCars(List<String> carNames, RoundManager roundManager) {
        for (String carName : carNames) {
            roundManager.addRacingCar(new RacingCar(carName));
        }
    }

    private RoundManager initializeRoundManager(List<String> carNames) {
        Range range = new Range(4, 9);
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        AdvanceJudgement advanceJudgement = new AdvanceJudgement(range, numberGenerator);
        RoundManager roundManager = new RoundManager(advanceJudgement);
        setCars(carNames, roundManager);
        return roundManager;
    }

    private List<String> getWinningCarsName(List<RacingCarDto> sortedSortedRacingCars) {
        List<String> winningCarsNames = new ArrayList<>();
        for (int index = 0; index < sortedSortedRacingCars.size(); index++) {
            RacingCarDto targetCar = sortedSortedRacingCars.get(index);
            winningCarsNames.add(targetCar.getName());
        }
        RacingCarDto firstCar = sortedSortedRacingCars.get(FIRST_CAR_INDEX);
        return sortedSortedRacingCars.stream()
                .filter(car -> car.getPoint().equals(firstCar.getPoint()))
                .map(car -> car.getName())
                .collect(Collectors.toList());
    }
}
