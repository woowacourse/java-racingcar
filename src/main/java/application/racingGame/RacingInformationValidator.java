package application.racingGame;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RacingInformationValidator {

    public static final int MAX_CAR_LENGTH = 5;
    public static final String LETTERING_SEPARATOR = "";
    public static final int ZERO = 0;
    public static final String BLANK = " ";

    public static int validateRacingLab(String input) {
        int racingLab = checkRacingLabValue(input);
        return racingLab;
    }

    public static void validateCarName(List<String> carNames) {
        checkDuplicateCarName(carNames);
        for (String carName : carNames) {
            checkNullOrBlankOrEmpty(carName);
            checkLengthMoreThanFive(carName);
        }
    }

    public static int checkRacingLabValue(String input) {
        int racingLab;
        try {
            racingLab = Integer.parseInt(input);
            checkNegativeNumber(racingLab);
        } catch(Exception e){
            throw new IllegalArgumentException("양의 숫자를 다시 입력하십시오.\n 잘못된 값을 입력했으므로 다시 시작합니다.");
        }
        return racingLab;
    }

    public static void checkNegativeNumber(int racingLab) {
        if(isNegativeNumber(racingLab)) {
            throw new IllegalArgumentException("0 이상의 수를 입력하십시오.");
        }
    }

    private static boolean isNegativeNumber(int racingLab) {
        return racingLab < ZERO;
    }

    public static void checkDuplicateCarName(List<String> carName) {
        Set<String> nonDuplicateName = new HashSet<>(carName);
        if (isDuplicateName(carName, nonDuplicateName)) {
            throw new IllegalArgumentException("중복된 자동차 이름을 입력하였습니다.");
        }
    }

    private static boolean isDuplicateName(List<String> carName, Set<String> nonDuplicateName) {
        return nonDuplicateName.size() != carName.size();
    }

    public static void checkNullOrBlankOrEmpty(String carName) {
        if (isEmptyOrOrContainBlank(carName)) {
            throw new IllegalArgumentException("공백을 포함한 이름을 입력하였습니다.");
        } else if(isNull(carName)) {
            throw new NullPointerException("null 값이 입력되었습니다");
        }
    }

    private static boolean isNull(String input) {
        return input == null;
    }

    public static void checkLengthMoreThanFive(String carName) {
        if (isLengthMoreThanFive(carName)) {
            throw new IllegalArgumentException("5글자 초과의 자동차 이름을 입력하였습니다.");
        }
    }

    private static boolean isLengthMoreThanFive(String s) {
        return s.length() > MAX_CAR_LENGTH;
    }

    private static boolean isEmptyOrOrContainBlank(String input) {
        return input.isEmpty() ||  isContainBlank(input);
    }

    private static boolean isContainBlank(String input) {
        String[] splitName = input.split(LETTERING_SEPARATOR);
        for (String s : splitName) {
            if (isBlankString(s)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isBlankString(String s) {
        return BLANK.equals(s);
    }
}
