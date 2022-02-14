package racingcar.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String REQUIRE_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String COMMA_DELIMITER = ",";
    private static final String REQUIRE_GAME_TURN_MESSAGE = "시도할 회수는 몇회인가요?";
    public static final String NOT_NUMBER_ERROR = "[ERROR] 숫자를 입력하세요.";
    private final Scanner scanner = new Scanner(System.in);

    public List<String> getCarNames() {
        System.out.println(REQUIRE_CAR_NAMES_MESSAGE);
        return splitCarNames(scanner.nextLine());
    }

    private List<String> splitCarNames(String carNames) {
        return Arrays.asList(carNames.split(COMMA_DELIMITER));
    }

    public int getGameTurn() {
        try {
            System.out.println(REQUIRE_GAME_TURN_MESSAGE);
            return Integer.parseInt(scanner.nextLine());
        } catch (IllegalArgumentException exception) {
            System.out.println(NOT_NUMBER_ERROR);
            return getGameTurn();
        }
    }
}
