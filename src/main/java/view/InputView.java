package view;

import domain.Name;
import exception.CommaNotFoundException;
import exception.NameIsOutOfBoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.util.Collections.addAll;
import static java.util.stream.Collectors.*;

public class InputView {

    private static final String COMMA = ",";
    private static final String requestCarNameMessage = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String requestTryCountMessage = "시도할 회수는 몇회인가요?";

    private static Scanner scanner;

    public static List<Name> requestCarName() {
        System.out.println(requestCarNameMessage);

        try {
            return sliceNames();
        } catch (CommaNotFoundException | NameIsOutOfBoundException e) {
            System.out.println(e.getMessage());
            return requestCarName();
        }
    }

    private static List<Name> sliceNames() {
        return sliceNameByComma(input()).stream().map(Name::new)
                .collect(toList());
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
            throw new CommaNotFoundException();
        }
    }

    public static String requestTryCount() {
        System.out.println(requestTryCountMessage);
        return input();
    }

    private static String input() {
        if (scanner == null) {
            scanner = new Scanner(System.in);
        }
        return scanner.nextLine();
    }
}
