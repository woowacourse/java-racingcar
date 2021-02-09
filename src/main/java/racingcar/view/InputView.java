package racingcar.view;

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

    private static InputView instance;

    private final Scanner scanner;
    private final OutputView outputView;

    private InputView(Scanner scanner) {
        this.scanner = scanner;
        this.outputView = OutputView.getInstance();
    }

    public static InputView getInstance() {
        if (instance == null) {
            instance = new InputView(new Scanner(System.in));
        }
        return instance;
    }

    private String deleteWhiteSpaces(String string) {
        return string.replaceAll("\\s+", "");
    }

    private String requestUserInputWithMessage(String message) {
        System.out.println(message);
        try {
            String rawString = deleteWhiteSpaces(scanner.nextLine());
            isNotEmptyStringOrThrow(rawString);
            return rawString;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return requestUserInputWithMessage(message);
        }
    }

    private void isNotEmptyStringOrThrow(String string) {
        if (string.equals("")) {
            throw new IllegalArgumentException(ERROR_NONE_INPUT_VALUE);
        }
    }

    public List<String> requestCarNames() {
        String rawString = requestUserInputWithMessage(MESSAGE_REQUEST_CAR_NAMES);
        return Arrays.asList(rawString.split(","));
    }

    public int requestRoundNumber() {
        String rawString = requestUserInputWithMessage(MESSAGE_REQUEST_ROUND_NUMBER);
        try {
            return parseIntOrThrow(rawString);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            return requestRoundNumber();
        }
    }

    private int parseIntOrThrow(String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_INVALID_INPUT_VALUE);
        }
    }
}
