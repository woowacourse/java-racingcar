package racingcar.view;

import java.util.*;

import static java.util.Arrays.asList;
import static racingcar.domain.Car.*;
import static racingcar.domain.Cars.DUPLICATE_NAME_ERROR_MESSAGE;
import static sun.tools.jconsole.Messages.BLANK;


//TODO
// validation 도메인에 있는것들 iputview에도 추가하기
public class InputView {
    private static final String COMMA = ",";
    private static final Scanner scanner = new Scanner(System.in);

    public static String nextLine() {
        return scanner.nextLine();
    }

    public static List<String> takeNameInput() {
        String input = scanner.nextLine();
        List<String> names = Arrays.asList(input.split(COMMA));

        validateDuplicateName(names);
        names.forEach(name -> {
            validateBlankInName(name);
            validateNameLength(name);
        });
        return names;
    }

    //TODO
    // 검증 Test 구현
    private static void validateBlankInName(String name) {
        if (name.contains(BLANK)) {
            throw new IllegalArgumentException(BLANK_ERROR_MESSAGE);
        }
    }

    private static void validateNameLength(String name) {
        if (name.length() < MINIMUM_NAME_LENGTH || MAXIMUM_NAME_LENGTH < name.length()) {
            throw new IllegalArgumentException(NAME_LENGTH_ERROR_MESSAGE);
        }
    }

    private static void validateDuplicateName(List<String> names) {
        Set<String> nameSet = new HashSet<>(names);
        if (nameSet.size() != names.size()) {
            throw new IllegalArgumentException(DUPLICATE_NAME_ERROR_MESSAGE);
        }
    }
}