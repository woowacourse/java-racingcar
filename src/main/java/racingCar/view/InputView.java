package racingCar.view;

import java.util.Scanner;
import racingCar.exception.NullInputException;

public class InputView {
    private static final String REQUEST_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String REQUEST_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final Scanner scanner = new Scanner(System.in);

    public static String getNames() {
        System.out.println(REQUEST_NAMES_MESSAGE);
        String names = scanner.next();
        validate(names);
        return names;
    }

    public static String getCount() {
        System.out.println(REQUEST_COUNT_MESSAGE);
        String count = scanner.next();
        validate(count);
        return count;
    }

    public static String validate(String inputString) {
        if (inputString == null || inputString.isEmpty()) {
            throw new NullInputException();
        }
        return inputString;
    }
}