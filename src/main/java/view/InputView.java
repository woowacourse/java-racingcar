package view;

import utils.CarNameValidator;
import utils.NumberValidator;
import utils.StringParser;

import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final String READ_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String READ_ATTEMPT_NUMBER_MESSAGE = "시도할 회수는 몇회인가요?";

    private static final Scanner scanner = new Scanner(System.in);

    public static List<String> readCarName() {
        try {
            System.out.println(READ_CAR_NAME_MESSAGE);
            String input = scanner.next();
            List<String> carNames = StringParser.splitByComma(input);
            validate(carNames);
            return carNames;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readCarName();
        }
    }

    private static void validate(List<String> carNames) {
        for (String carName : carNames) {
            CarNameValidator.validate(carName);
        }
    }

    public static int readAttemptNumber() {
        try {
            System.out.println(READ_ATTEMPT_NUMBER_MESSAGE);
            String input = scanner.next();
            return NumberValidator.validate(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readAttemptNumber();
        }
    }
}
