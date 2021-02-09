package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    public static Cars cars;
    public static int trials;

    public static void start() {
        while (!initializeCars()) ;
        while (!getTrials()) ;
        OutputView.printRoundMessage();
        playRounds();
        OutputView.printWinners(findWinners());
    }

    public static List<Car> findWinners() {
        int max = cars.getMaxDistance();
        cars.getCars()
                .stream()
                .forEach(car -> car.isMaxPosition(max));
        return cars.getCars()
                .stream()
                .filter(car -> car.isMaxPosition(max))
                .collect(Collectors.toList());
    }

    public static void playRounds() {
        for (int i = 0; i < trials; i++) {
            playRound();
            OutputView.printRoundResult(cars);
        }
    }

    public static void playRound() {
        cars.moveCars();
    }

    public static boolean initializeCars() {
        try {
            OutputView.printUserPromptCarNames();
            cars = new Cars(splitInput(InputView.askUserInput())
                    .stream()
                    .collect(Collectors.toList()));
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }

    public static List<String> splitInput(String input) {
        return Arrays.asList(input.split(","));
    }

    public static boolean getTrials() {
        OutputView.printUserPromptTrials();
        String input = InputView.askUserInput().trim();
        if (validateTrials(input)) {
            trials = Integer.parseInt(input);
            return true;
        }
        return false;
    }

    public static boolean validateTrials(String input) {
        try {
            isValidNumber(input);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            OutputView.printErrorRetrialMessage();
            return false;
        }
        return true;
    }

    public static void isValidNumber(String input){
        if(Integer.parseInt(input) < 1){
            throw new IllegalArgumentException("시행 횟수는 1회 이상이어야 합니다.");
        }
    }
}
