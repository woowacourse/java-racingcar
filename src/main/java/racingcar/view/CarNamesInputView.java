package racingcar.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import racingcar.utils.validator.CarNameValidator;

public class CarNamesInputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String NAME_DELIMITER = ",";

    public static List<String> getCarNames() {
        String userInput = userCarNameInput();
        try {
            List<String> carNames = separateCarNames(userInput);
            carNames.forEach(CarNameValidator::validate);
            return carNames;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getCarNames();
        }
    }

    private static String userCarNameInput() {
        System.out.println(CAR_NAME_INPUT_MESSAGE);
        return scanner.nextLine();
    }

    private static List<String> separateCarNames(String userInput) {
        return Arrays.asList(userInput.split(NAME_DELIMITER, -1));
    }
}
