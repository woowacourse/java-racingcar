package racingcar.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String CAR_NAMES_GUIDE_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String TIMES_GUIDE_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String TWO_COMMAS_ERROR_MESSAGE = "[ERROR] 2개 이상의 쉼표가 연속으로 올 수 없습니다: ";
    private static final String NON_DIGIT_ERROR_MESSAGE = "[ERROR] 숫자만 입력해 주세요: ";
    private static final String TWO_COMMAS = ",,";
    private static final String NAMES_DELIMITER = ",";

    private final Scanner scanner;

    public InputView(final Scanner scanner) {
        this.scanner = scanner;
    }

    public List<String> scanCarNames() {
        System.out.println(CAR_NAMES_GUIDE_MESSAGE);
        final String carNames = scanner.nextLine().trim();

        if (carNames.contains(TWO_COMMAS)) {
            throw new IllegalArgumentException(TWO_COMMAS_ERROR_MESSAGE + carNames);
        }

        return Arrays.asList(carNames.split(NAMES_DELIMITER));
    }

    public int scanTimes() {
        System.out.println(TIMES_GUIDE_MESSAGE);
        final String times = scanner.nextLine().trim();

        try {
            return Integer.parseInt(times);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NON_DIGIT_ERROR_MESSAGE + times);
        }
    }
}
