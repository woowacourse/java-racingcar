package application.racing.domain;

import java.util.*;

public class CarNames {
    private final static int FIVE = 5;
    private final static String NAME_DELIMITER = ",";
    private final static String EMPTY = "";
    private final static String BLANK = " ";
    private final static String ERR_MESSAGE_FOR_DUPLICATE_NAME = "중복된 자동차 이름을 입력하였습니다.";
    private final static String ERR_MESSAGE_FOR_NAME_LENGTH_OVER = "5글자 초과의 자동차 이름을 입력하였습니다.";
    private final static String ERR_MESSAGE_FOR_NAME_WITH_BLANK = "공백을 포함한 이름을 입력하였습니다.";

    private List<String> carNames;

    public CarNames(String input) {
        throwExceptionWhenInputIsNullOrEmptyOrBlank(input);
        String[] names = input.split(NAME_DELIMITER);
        addCarName(names);
        validateName();
        throwExceptionWhenHasDuplicateCarName();
    }

    private void throwExceptionWhenHasDuplicateCarName() {
        Set<String> nonDuplicateName = new HashSet<>(this.carNames);
        if (nonDuplicateName.size() != this.carNames.size()) {
            throw new IllegalArgumentException(ERR_MESSAGE_FOR_DUPLICATE_NAME);
        }
    }

    private void addCarName(String[] splitName) {
        this.carNames = new ArrayList(Arrays.asList(splitName));
    }

    private void throwExceptionWhenNameLengthOverFive(String s) {
        if (s.length() > FIVE) {
            throw new IllegalArgumentException(ERR_MESSAGE_FOR_NAME_LENGTH_OVER);
        }
    }

    private void validateName() {
        for (String s : this.carNames) {
            throwExceptionWhenInputIsNullOrEmptyOrBlank(s);
            throwExceptionWhenNameLengthOverFive(s);
        }
    }

    private void throwExceptionWhenInputIsNullOrEmptyOrBlank(String input) {
        if (input == null || input.isEmpty() || isContainBlank(input)) {
            throw new IllegalArgumentException(ERR_MESSAGE_FOR_NAME_WITH_BLANK);
        }
    }

    private boolean isContainBlank(String input) {
        String[] splitName = input.split(EMPTY);
        for (String s : splitName) {
            if (BLANK.equals(s)) {
                return true;
            }
        }
        return false;
    }

    public List<String> getCarNameList() {
        return this.carNames;
    }
}
