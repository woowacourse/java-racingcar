package racingcargame.view.exception;

import racingcargame.util.Spliter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CarNameException {

    public static final Set<String> CAR_NAMES = new HashSet<>();
    public static final int NAME_MAX_LENGTH = 5;

    public static boolean validOneCar(String input) {
        return !input.contains(Spliter.DELIMITER);
    }

    public static void addName(String[] input) {
        CAR_NAMES.addAll(Arrays.asList(input));
    }

    public static boolean isDuplicatedNames(String[] input) {
        for (String name : input) {
            if (CAR_NAMES.contains(name)) {
                return true;
            }
        }
        return false;
    }

    public static void haveExceededLengthName() {
        for (String name : CAR_NAMES) {
            if (isExceedLength(name)) {
                throw new RuntimeException();
            }
        }
    }

    private static boolean isExceedLength(String name) {
        return name.length() > NAME_MAX_LENGTH;
    }

    public static void checkBlankInput() {
        for (String name : CAR_NAMES) {
            if(name.equals("")) {
                throw new RuntimeException();
            }
        }
    }
}
