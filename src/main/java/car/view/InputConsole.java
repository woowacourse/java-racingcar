package car.view;

import java.util.Scanner;
import java.util.regex.Pattern;



public class InputConsole implements Input {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_TRIAL_COUNT_LENGTH = 10;
    private static final Pattern NOT_INTEGER_PATTERN = Pattern.compile("\\D+");
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
            throw new IllegalArgumentException("[ERROR] 이름이 너무 깁니다.");
        }
        if (name.length() < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 이름이 너무 짧습니다.");
        }
    }
    private void catchInputTrialCountException(String input){
        validateInteger(input);
        validateTrialCountUnderMaxInteger(input);
    }
    private void validateInteger(String input) {
        if (NOT_INTEGER_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException("시도 횟수는 정수여야 합니다");
        }
    }

    private void validateTrialCountUnderMaxInteger(String input) {
        if (input.length() >= MAX_TRIAL_COUNT_LENGTH) {
            throw new IllegalArgumentException("시도 횟수는 999999999이하여야 합니다.");
        }
    }
}
