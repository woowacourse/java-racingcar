package racingcar.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputView {

    private static final int ROUND_MIN_NUM = 1;
    private static final String READ_CARS_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String READ_RACING_ROUND_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String ROUND_INPUT_ERROR = "[ERROR] 라운드는 숫자여야 합니다.";
    private static final String ROUND_NUMBER_ERROR = "[ERROR] 시도 횟수는 1이상이어야 합니다.";
    private static final Pattern pattern = Pattern.compile("^[0-9]+$");

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public List<String> readCarNames() {
        System.out.println(READ_CARS_NAME_MESSAGE);

        return Arrays.asList(scanner.nextLine().trim().split(","));
    }

    public int readRacingRound() {
        System.out.println(READ_RACING_ROUND_MESSAGE);
        String round = scanner.nextLine().trim();
        validateRoundInput(round);
        return Integer.parseInt(round);
    }

    private void validateRoundInput(String round) {
        Matcher matcher = pattern.matcher(round);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(ROUND_INPUT_ERROR);
        }
        if (Integer.parseInt(round) < ROUND_MIN_NUM) {
            throw new IllegalArgumentException(ROUND_NUMBER_ERROR);
        }
    }

}
