package controller;

import model.Cars;
import view.InputView;
import view.OutputView;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGameContoller {
    public static Cars cars;
    public static int trials;

    public static void start() {
        while (!initializeCars()) ;
        while (!getTrials()) ;
        OutputView.printResultMessage();
        playRounds();
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
                    .map(String::trim)
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
            Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            System.err.println(e);
            OutputView.printErrorRetrialMessage();
            return false;
        }
        return true;
    }
}
