package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputView {

    private static final int MAX_TRIAL_NUM = 2;
    private static final int MIN_CAR_NAME_LENGTH = 1;
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final Pattern NUMBER = Pattern.compile("[0-9]+");

    private Scanner scanner;

    public List<String> readCarNames() {
        System.out.println(Messages.INPUT_CAR_NAMES);
        String[] carNames = readLine().split(",");

        validateCarNames(carNames);
        return Arrays.stream(carNames)
            .collect(Collectors.toList());
    }

    private String readLine() {
        if (scanner == null) {
            scanner = new Scanner(System.in);
        }
        return scanner.nextLine();
    }

    private void validateCarNames(String[] inputCarNames) {
        if (inputCarNames.length == 0) {
            throw new IllegalArgumentException(Messages.ERROR_CAR_NAME_LENGTH);
        }
        for (String inputCarName : inputCarNames) {
            validateCarName(inputCarName);
        }
    }

    private void validateCarName(String inputCarName) {
        if (inputCarName.length() < MIN_CAR_NAME_LENGTH
            || inputCarName.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(Messages.ERROR_CAR_NAME_LENGTH);
        }
    }

    public int readTrialNum() {
        System.out.println(Messages.INPUT_TRIAL_NUM);
        String input = readLine();
        validateTrialNum(input);
        return Integer.parseInt(input);
    }

    private void validateTrialNum(String input) {
        validateOnlyNum(input);
        validateTrialMaxNum(input);
    }

    private void validateTrialMaxNum(String input) {
        if (input.length() > MAX_TRIAL_NUM) {
            throw new IllegalArgumentException(Messages.ERROR_MAX_TRIAL_NUM);
        }
    }

    private void validateOnlyNum(String input) {
        boolean isNumber = !NUMBER.matcher(input).matches();
        if (isNumber) {
            throw new IllegalArgumentException(Messages.ERROR_TRIAL_NOT_NUMBER);
        }
    }
}
