package view;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Supplier;
import java.util.regex.Pattern;

public class InputView {

    private static final Pattern NAME_REGEX = Pattern.compile("(.+)((,)(.+))*");
    private static final Pattern TRIAL_REGEX = Pattern.compile("[0-9]+");
    private static final String ERROR_MESSAGE = "[ERROR] 입력 형식이 올바르지 않습니다.";
    private final Scanner scanner = new Scanner(System.in);

    public <T> T retryInputOnException(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_MESSAGE);
            return retryInputOnException(supplier);
        }
    }

    public String receiveNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String names = scanner.nextLine();
        validateCarNames(names);
        return names;
    }

    private void validateCarNames(String names) {
        if (isInvalidFormat(names, NAME_REGEX)) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
        if (hasInvalidNameLength(names.split(","))) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    private boolean hasInvalidNameLength(String[] names) {
        return Arrays.stream(names)
                .anyMatch(name -> name.isBlank() || name.length() > 5);
    }

    public int receiveTrialCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String trial = scanner.nextLine();

        validateTrialCount(trial);
        return Integer.parseInt(trial);
    }

    private void validateTrialCount(String trialCount) {
        if (isInvalidFormat(trialCount, TRIAL_REGEX)) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    private boolean isInvalidFormat(String input, Pattern pattern) {
        return !pattern.matcher(input).matches();
    }
}
