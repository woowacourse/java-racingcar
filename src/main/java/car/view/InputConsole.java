package car.view;

import java.util.Scanner;
import java.util.regex.Pattern;

import static car.option.Option.MAX_TRIAL_COUNT_LENGTH;


public class InputConsole implements Input {
    private static final Pattern NOT_INTEGER_PATTERN = Pattern.compile("\\D+");
    Scanner scanner = new Scanner(System.in);

    @Override
    public String inputCarNames() {
        return scanner.nextLine();
    }

    @Override
    public String inputTrialCount() {
        String input = scanner.nextLine();
        validateInteger(input);
        validateTrialCountUnderMaxInteger(input);
        return input;
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
