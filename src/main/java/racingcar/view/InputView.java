package racingcar.view;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class InputView {

    private static final String REQUEST_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String REQUEST_ATTEMPT_MESSAGE = "시도할 회수는 몇회인가요?";

    public static String requestCarName(Scanner scanner) {
        System.out.println(REQUEST_CAR_NAME_MESSAGE);
        return readNextLine(scanner);
    }

    public static String requestAttempt(Scanner scanner) {
        System.out.println(REQUEST_ATTEMPT_MESSAGE);
        String attemptInput = readNextLine(scanner);
        System.out.println();
        return attemptInput;
    }

    private static String readNextLine(Scanner scanner) {
        try {
            return scanner.nextLine();
        } catch (NoSuchElementException exception) {
            throw new RuntimeException(ErrorMessage.INPUT_EMPTY.toString());
        }
    }
}
