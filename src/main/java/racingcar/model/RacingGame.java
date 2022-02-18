package racingcar.model;

import racingcar.util.InputValidator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private static final String COMMA = ",";
    private static final String BLANK = "";
    private static final String SPACE = " ";

    private Cars cars;
    private int trialNum;

    public RacingGame() {
    }

    public RacingGame(String carNames, String inputTrialNum) {
        List<String> splitCarNames = splitCars(carNames);
        this.cars = initCars(splitCarNames);
        this.trialNum = convertToInteger(inputTrialNum);
    }

    private int convertToInteger(String number) {
        InputValidator.validateTrialInput(number);
        return Integer.parseInt(number);
    }

    public List<String> splitCars(String carNames) {
        InputValidator.validateNameInput(carNames);
        List<String> splitCarNames = Arrays.asList(splitNameWithoutSpace(carNames));
        InputValidator.validateEmptyCarName(splitCarNames);
        InputValidator.validateCarNameLength(splitCarNames);
        InputValidator.validateDuplicateName(splitCarNames);

        return splitCarNames;
    }

    private String[] splitNameWithoutSpace(String carNames) {
        return carNames.replaceAll(SPACE, BLANK).split(COMMA);
    }

    public Cars initCars(List<String> carNames) {
        return new Cars(carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList()));
    }

    public void race() {
        cars.race();
    }

    public Cars getCars() {
        return cars;
    }

    public int getTrialNum() {
        return trialNum;
    }

}
