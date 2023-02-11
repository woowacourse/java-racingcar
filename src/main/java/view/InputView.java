package view;

import static exception.ErrorMessage.ENTER_NAME_WITH_COMMA;
import static java.util.Collections.addAll;

import exception.CommaNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final String REQUEST_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String REQUEST_TRY_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";

    private static final String COMMA = ",";

    private static final Scanner scanner = new Scanner(System.in);

    public static List<String> requestCarName() {
        System.out.println(REQUEST_CAR_NAME_MESSAGE);
        return sliceNameByComma(input());
    }

    public static String requestTryCount() {
        System.out.println(REQUEST_TRY_COUNT_MESSAGE);
        return input();
    }

    private static String input() {
        return scanner.nextLine();
    }

    private static List<String> sliceNameByComma(final String names) {
        validateComma(names);

        return getSplitName(names);
    }

    private static List<String> getSplitName(final String names) {
        List<String> splitNames = new ArrayList<>();

        addAll(splitNames, names.split(COMMA));

        return splitNames;
    }

    private static void validateComma(final String names) {
        if (!names.contains(COMMA)) {
            throw new CommaNotFoundException(ENTER_NAME_WITH_COMMA.toString());
        }
    }
}
