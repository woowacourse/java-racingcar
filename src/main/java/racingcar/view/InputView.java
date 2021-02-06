package racingcar.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * InputView.java
 * 입력과 출력이 섞인 로직을 담당하는 View 클래스
 *
 * @author Kimun Kim, github.com/tributetothemoon
 * @author TaeHyeok Lee , github.com/taelee42
 */
public class InputView {
    private static final String MESSAGE_REQUEST_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String MESSAGE_REQUEST_ROUND_NUMBER = "시도할 회수는 몇회인가요?";
    private static final String ERROR_NONE_INPUT_VALUE = "입력값이 없습니다.";
    private static final String ERROR_INVALID_INPUT_VALUE = "유효하지 않은 입력입니다.";

    private static Scanner scanner;

    public static void setScanner(Scanner scanner) {
        InputView.scanner = scanner;
    }

    private static String deleteWhiteSpaces(String string) {
        return string.replaceAll("\\s+", "");
    }

    private static String getInputWithMessage(String message) {
        System.out.println(message);
        try {
            String rawString = deleteWhiteSpaces(scanner.nextLine());
            isNotEmptyStringOrThrowException(rawString);
            return rawString;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getInputWithMessage(message);
        }
    }

    private static void isNotEmptyStringOrThrowException(String string) {
        if (string.equals("")) {
            throw new IllegalArgumentException(ERROR_NONE_INPUT_VALUE);
        }
    }

    public static List<String> getCarNames() {
        String rawString = getInputWithMessage(MESSAGE_REQUEST_CAR_NAMES);
        return new ArrayList<>(Arrays.asList(rawString.split(",")));
    }

    public static int getRoundNumber() {
        String rawString = getInputWithMessage(MESSAGE_REQUEST_ROUND_NUMBER);
        try {
            return parseIntOrThrowException(rawString);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
            return getRoundNumber();
        }
    }

    private static int parseIntOrThrowException(String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_INVALID_INPUT_VALUE);
        }
    }
}