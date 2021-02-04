package racingcar.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String CAR_NAME_DELIMITER = ",";
    private static final String PLEASE_INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)";

    public static List<String> inputCarNames(Scanner scanner) {
        System.out.println(PLEASE_INPUT_CAR_NAMES_MESSAGE);
        String input = scanner.nextLine();
        String[] carNames = input.split(CAR_NAME_DELIMITER);

        return Arrays.asList(carNames);
    }
}
