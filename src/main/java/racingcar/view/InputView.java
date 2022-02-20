package racingcar.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String CAR_NAME_DELIMITER = ",";
    private static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INPUT_TRIAL_MESSAGE = "시도할 회수는 몇회인가요?";

    private static final Scanner scanner = new Scanner(System.in);

    public static List<String> getCarNames() throws RuntimeException {
        System.out.println(INPUT_CAR_NAMES_MESSAGE);
        String carNames = validateCarNames(scanner.nextLine());
        return splitCarNamesInput(carNames);
    }

    private static List<String> splitCarNamesInput(String carNamesInput) {
        return Arrays.asList(carNamesInput.split(CAR_NAME_DELIMITER, -1));
    }

    private static String validateCarNames(String input) {
        InputValidator.checkCarNamesInput(input);
        return input;
    }

    public static int getTrialCount() throws RuntimeException {
        System.out.println(INPUT_TRIAL_MESSAGE);
        return validateCountAndTransferToInt(scanner.nextLine());
    }

    private static int validateCountAndTransferToInt(String input) {
        InputValidator.checkTrialCount(input);
        return Integer.parseInt(input);
    }
}
