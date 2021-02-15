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

    public void start() {
        Cars cars = new Cars();
        while (!initializeCars(cars)) ;

        int trials = -1;
        while(trials == -1){
            trials = getTrials();
        }
        OutputView.printRoundMessage();
        playRounds(cars, trials);
        OutputView.printWinners(findWinners(cars));
    }


    public List<Car> findWinners(Cars cars) {
        return cars.getCars()
                .stream()
                .filter(car -> car.isSamePosition(cars.getMaxDistance()))
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
            List<Car> carsList = splitInput(InputView.askUserInput())
                    .stream()
                    .map(Car::new)
                    .collect(Collectors.toList());
            cars.assignCars(carsList);
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }

    private int getTrials() {
        OutputView.printUserPromptTrials();
        String input = InputView.askUserInput().trim();
        if (validateTrials(input)) {
            return Integer.parseInt(input);
        }
        return -1;
    }

    private void playRounds(Cars cars, int trials) {
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
