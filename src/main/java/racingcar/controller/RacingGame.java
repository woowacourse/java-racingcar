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
    public static Cars cars;
    public static int trials;

    public static void start() {
        initSetting();
        playRounds();
        printWinners();
    }

    private static void initSetting() {
        while (!initializeCars()) ;
        while (!getTrials()) ;
    }

    private static boolean initializeCars() {
        try {
            OutputView.printUserPromptCarNames();
            List<Car> temporaryCars = new ArrayList<>();
            splitInput(InputView.askUserInput())
                    .stream()
                    .forEach(carName -> temporaryCars.add(new Car(carName)));
            assignCars(temporaryCars);
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }

    public static List<String> splitInput(String input) {
        return Arrays.asList(input.split(DELIMITER));
    }

    public static void assignCars(List<Car> temporaryCars) {
        cars = new Cars(temporaryCars);
    }

    private static boolean getTrials() {
        OutputView.printUserPromptTrials();
        String input = InputView.askUserInput().trim();
        if (validateTrials(input)) {
            trials = Integer.parseInt(input);
            return true;
        }
        return false;
    }

    private static boolean validateTrials(String input) {
        try {
            isValidNumber(input);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            OutputView.printErrorRetrialMessage();
            return false;
        }
        return true;
    }

    public static void isValidNumber(String input) {
        if (Integer.parseInt(input) < 1) {
            throw new IllegalArgumentException("시행 횟수는 1회 이상이어야 합니다.");
        }
    }

    public static List<Car> findWinners() {
        return cars.getCars()
                .stream()
                .filter(car -> car.isSamePosition(cars.getMaxDistance()))
                .collect(Collectors.toList());
    }

    private static void playRounds() {
        OutputView.printRoundMessage();
        for (int i = 0; i < trials; i++) {
            playRound();
            OutputView.printRoundResult(cars);
        }
    }

    private static void playRound() {
        cars.moveCars();
    }

    private static void printWinners() {
        OutputView.printWinners(findWinners());
    }
}
