package racingcar.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INPUT_TRY_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String CAR_NAME_DELIMITER = ",";
    private static final Scanner CONSOLE = new Scanner(System.in);

    private InputView() {
    }

    public static List<String> getCarNames() {
        System.out.println(INPUT_CAR_NAMES_MESSAGE);
        String carNames = CONSOLE.nextLine();
        Validator.validateCarNames(carNames);
        return Arrays.asList(carNames.split(CAR_NAME_DELIMITER));
    }

    public static int inputTryCount() {
        System.out.println(INPUT_TRY_COUNT_MESSAGE);
        String tryCountText = CONSOLE.nextLine();
        Validator.validateTryCount(tryCountText);
        return Integer.parseInt(tryCountText);
    }
}
