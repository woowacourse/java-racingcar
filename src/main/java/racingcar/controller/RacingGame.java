package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private static final String DELIMITER = ",";
    private static int trials;

    public void start() {
        Cars cars = new Cars();
        while (!initializeCars(cars)) ;
        while (!getTrials()) ;
        OutputView.printRoundMessage();
        playRounds(cars);
        OutputView.printWinners(findWinners(cars));
    }


    public List<Car> findWinners(Cars cars) {
        return cars.getCars()
                .stream()
                .filter(car -> car.isMaxPosition(cars.getMaxDistance()))
                .collect(Collectors.toList());
    }

    public List<String> splitInput(String input) {
        return Arrays.asList(input.split(DELIMITER));
    }

    public void isValidNumber(String input) {
        if (Integer.parseInt(input) < 1) {
            throw new IllegalArgumentException("시행 횟수는 1회 이상이어야 합니다.");
        }
    }

    private boolean initializeCars(Cars cars) {
        try {
            OutputView.printUserPromptCarNames();
            List<Car> temporaryCars = new ArrayList<>();
            splitInput(InputView.askUserInput())
                    .stream()
                    .forEach(carName -> temporaryCars.add(new Car(carName)));
            cars.assignCars(temporaryCars);
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
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

    private void playRounds(Cars cars) {
        for (int i = 0; i < trials; i++) {
            playRound(cars);
            OutputView.printRoundResult(cars);
        }
    }

    private void playRound(Cars cars) {
        cars.moveCars();
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
}
