package controller;

import model.CarRepository;
import view.InputView;
import view.OutputView;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGameContoller {
    public static void start() {
        List<String> carNames = getCarNames();
        int trials = getTrials();
//        CarRepository.moveCars();
    }

    public static List<String> getCarNames() {
        while (true) {
            OutputView.printUserPromptCarNames();
            String input = InputView.askUserInput();
            List<String> splittedInput = splitInput(input)
                    .stream()
                    .map(String::trim)
                    .collect(Collectors.toList());
            if (validateCarNames(splittedInput)) {
                return splittedInput;
            }
        }
    }

    public static List<String> splitInput(String input) {
        return Arrays.asList(input.split(","));
    }

    public static boolean validateCarNames(List<String> splittedInput) {
        try {
            if (splittedInput.size() <= 1) {
                throw new IllegalArgumentException();
            }
            if (splittedInput.stream()
                    .filter(name -> name.length() > 5)
                    .findAny()
                    .isPresent()) {
                throw new IllegalArgumentException();
            }
            if (!splittedInput.stream()
                    .filter(count -> Collections.frequency(splittedInput, count) > 1)
                    .collect(Collectors.toSet())
                    .isEmpty()) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.err.println(e);
            OutputView.printErrorRetrialMessage();
            return false;
        }
        return true;
    }

    public static int getTrials() {
        while (true) {
            OutputView.printUserPromptTrials();
            String input = InputView.askUserInput().trim();
            if (validateTrials(input)) {
                return Integer.parseInt(input);
            }
        }
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
