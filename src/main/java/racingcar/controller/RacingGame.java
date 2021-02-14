package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private static final String DELIMITER = ",";
    private Cars cars;
    private int trials;

    public void start() {
        initSetting();
        playRounds();
        printWinners();
    }

    private void initSetting() {
        while (!initializeCars()) ;
        while (!getTrials()) ;
    }

    private boolean initializeCars() {
        try {
            OutputView.printUserPromptCarNames();
            assignCars(splitInput(InputView.askUserInput())
                    .stream()
                    .map(Car::new)
                    .collect(Collectors.toList())
            );
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }

    public List<String> splitInput(String input) {
        return Arrays.asList(input.split(DELIMITER));
    }

    public void assignCars(List<Car> temporaryCars) {
        cars = new Cars(temporaryCars);
    }

    private boolean getTrials() {
        OutputView.printUserPromptTrials();
        String input = InputView.askUserInput().trim();
        if (validateTrials(input)) {
            trials = Integer.parseInt(input);
            return true;
        }
        return false;
    }

    private boolean validateTrials(String input) {
        try {
            isValidNumber(input);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            OutputView.printErrorRetrialMessage();
            return false;
        }
        return true;
    }

    public void isValidNumber(String input) {
        if (Integer.parseInt(input) < 1) {
            throw new IllegalArgumentException("시행 횟수는 1회 이상이어야 합니다.");
        }
    }

    public List<Car> findWinners() {
        return cars.getCars()
                .stream()
                .filter(car -> car.isSamePosition(cars.getMaxDistance()))
                .collect(Collectors.toList());
    }

    private void playRounds() {
        OutputView.printRoundMessage();
        for (int i = 0; i < trials; i++) {
            playRound();
            OutputView.printRoundResult(cars);
        }
    }

    private void playRound() {
        cars.moveCars();
    }

    private void printWinners() {
        OutputView.printWinners(findWinners());
    }
}
