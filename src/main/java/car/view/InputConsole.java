package car.view;

import java.util.Scanner;
import java.util.regex.Pattern;



public class InputConsole implements Input {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_TRIAL_COUNT_LENGTH = 10;
    private static final Pattern NOT_INTEGER_PATTERN = Pattern.compile("\\D+");
    private static final String LONGER_THAN_MAX_NAME_LENGTH_EXCEPTION_MASSAGE = "[ERROR] 이름이 너무 깁니다.";
    private static final String SHORTER_THAN_MIN_NAME_LENGTH_EXCEPTION_MASSAGE = "[ERROR] 이름이 너무 짧습니다.";
    private static final String NON_INTEGER_TRIAL_NUMBER_EXCEPTION_MASSAGE = "[ERROR] 시도 횟수는 정수여야 합니다";
    private static final int MAX_TRIAL_NUMBER = 999999999;
    private static final String OVER_MAX_TRIAL_NUMBER_EXCEPTION_MASSAGE = String.format("[ERROR] 시도 횟수는 %d 이하여야 합니다.",MAX_TRIAL_NUMBER);
    Scanner scanner = new Scanner(System.in);
    @Override
    public String inputCarNames() {
        String input = scanner.nextLine();
        catchInputCarNamesException(input);
        return input;
    }

    @Override
    public String inputTrialCount() {
        String input = scanner.nextLine();
        catchInputTrialCountException(input);
        return input;
    }
    private void catchInputCarNamesException(String input){
        validateNameLength(input);
    }
    private void validateNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(LONGER_THAN_MAX_NAME_LENGTH_EXCEPTION_MASSAGE);
        }
        if (name.length() < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException(SHORTER_THAN_MIN_NAME_LENGTH_EXCEPTION_MASSAGE);
        }
    }
    private void catchInputTrialCountException(String input){
        validateInteger(input);
        validateTrialCountUnderMaxInteger(input);
    }
    private void validateInteger(String input) {
        if (NOT_INTEGER_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException(NON_INTEGER_TRIAL_NUMBER_EXCEPTION_MASSAGE);
        }
    }

    private void validateTrialCountUnderMaxInteger(String input) {
        if (input.length() >= MAX_TRIAL_COUNT_LENGTH) {
            throw new IllegalArgumentException(OVER_MAX_TRIAL_NUMBER_EXCEPTION_MASSAGE);
        }
    }
}
