package racingcargame.model;

import java.util.*;

public class CarNamesValidator {
    private static final int MAXIMUM_NAME_LENGTH = 5;

    static void checkConditions(String carNames) {
        checkNullName(carNames);
        List<String> names = new ArrayList<>(Arrays.asList(carNames.split(",")));
        checkEmptyName(names);
        checkNameLength(names);
        checkDuplicatedName(names);
    }

    private static void checkDuplicatedName(List<String> names) {
        Set<String> namesWithoutDuplicates = new HashSet<>(names);
        if (names.size() != namesWithoutDuplicates.size()) {
            throw new IllegalArgumentException("중복된 이름이 존재합니다.\n다시 입력해주세요.");
        }
    }

    private static void checkNameLength(List<String> names) {
        boolean wrongNameLength = false;
        for (int i = 0, n = names.size(); i < n && !wrongNameLength; i++) {
            wrongNameLength = checkCurrentNameLength(names.get(i));
        }
        if (wrongNameLength) {
            throw new IllegalArgumentException("선수의 이름은 1이상 5이하로 해주세요!");
        }
    }

    private static boolean checkCurrentNameLength(String name) {
        if (name.isEmpty() || name.length() > MAXIMUM_NAME_LENGTH) {
            return true;
        }
        return false;
    }

    private static void checkNullName(String input) {
        if (input == null) {
            throw new IllegalArgumentException("입력하신 이름이 null입니다.\n다시 입력해주세요.");
        }
    }

    private static void checkEmptyName(List<String> names) {
        boolean emptyName = false;
        for (int i = 0, n = names.size(); i < n && !emptyName; i++ ){
            emptyName = checkEmptyName(names.get(i));
        }
        if (emptyName) {
            throw new IllegalArgumentException("입력하신 이름이 없습니다.\n다시 입력해주세요.");
        }
    }

    private static boolean checkEmptyName(String name) {
        if (name.isEmpty()) {
            return true;
        }
        return false;
    }
}
