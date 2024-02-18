package view;

import exception.DuplicateCarNameException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String ROUND_COUNT_NUMBER_FORMAT_EXCEPTION = "[ERROR] 시도 횟수는 숫자여야 합니다.";

    private InputView() {
    }

    public static String getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.nextLine();
    }

    public static List<String> getSplitCarNames(final String names) {
        List<String> splitNames = new ArrayList<>(Arrays.asList(names.split(",")));
        duplicateCarNamesValidation(splitNames);
        return splitNames;
    }

    private static void duplicateCarNamesValidation(List<String> splitNames) {
        Set<String> distinctNames = new HashSet<>();
        List<String> duplicatedNames = splitNames.stream()
                .filter(name -> !distinctNames.add(name))
                .toList();
        checkIsDuplicatedNamesNotEmpty(duplicatedNames);
    }

    private static void checkIsDuplicatedNamesNotEmpty(List<String> duplicatedNames) {
        if (!duplicatedNames.isEmpty()) {
            throw new DuplicateCarNameException(duplicatedNames);
        }
    }

    public static String getRacingRounds() {
        System.out.println("시도할 회수는 몇회인가요?");
        return scanner.nextLine();
    }

    public static Integer getParsedRacingRounds(final String counts) {
        try {
            return Integer.parseInt(counts);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ROUND_COUNT_NUMBER_FORMAT_EXCEPTION);
        }
    }
}
