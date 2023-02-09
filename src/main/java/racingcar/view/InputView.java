package racingcar.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final int ROUND_MIN_NUM = 1;
    private static final String READ_CARS_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String READ_RACING_ROUND_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String ROUND_NUMBER_ERROR = "[ERROR] 시도 횟수는 1이상이어야 합니다.";

    public List<String> readCarNames() {
        System.out.println(READ_CARS_NAME_MESSAGE);
        return Arrays.asList(scanner.nextLine().trim().split(","));
    }

    public int readRacingRound() {
        System.out.println(READ_RACING_ROUND_MESSAGE);
        int round = scanner.nextInt();
        validateRoundInput(round);
        return round;
    }

    private void validateRoundInput(int round) {
        if (round < ROUND_MIN_NUM) {
            throw new IllegalArgumentException(ROUND_NUMBER_ERROR);
        }
    }

}
