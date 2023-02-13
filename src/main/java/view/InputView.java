package view;

import static java.util.Collections.addAll;

import domain.Names;
import domain.TryCount;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final String REQUEST_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String REQUEST_TRY_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String ENTER_NAME_WITH_COMMA = "쉼표로 이름을 구분해주세요.";
    private static final String COMMA = ",";
    private static final Scanner scanner = new Scanner(System.in);

    public static Names requestCarName() {
        System.out.println(REQUEST_CAR_NAME_MESSAGE);

        try {
            return new Names(sliceNameByComma(input()));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return requestCarName();
        }
    }

    public static TryCount requestTryCount() {
        System.out.println(REQUEST_TRY_COUNT_MESSAGE);

        try {
            return new TryCount(input());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return requestTryCount();
        }
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
            throw new IllegalArgumentException(ENTER_NAME_WITH_COMMA);
        }
    }
}
