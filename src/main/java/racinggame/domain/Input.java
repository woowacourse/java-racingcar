package racinggame.domain;

import racinggame.view.InputView;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Input {
    public static final String LENGTH_ERROR_MESSAGE = "이름의 길이는 1자 이상, 5자" +
            " 이하만 가능합니다.";
    public static final String NUMBER_FORMAT_ERROR_MESSAGE = "횟수는 정수만 " +
            "가능합니다.";
    public static final String NOT_POSITIVE_ERROR_MESSAGE = "횟수는 1이상의" +
            " 정수만 가능합니다.";
    private static final String SPLIT_DELIMITER = ",";

    public static final int NAME_LENGTH_LIMIT = 5;

    private String names;
    private String repeat;

    public Input() {
        this(InputView.inputName(), InputView.inputRepeat());
    }

    public Input(String inputName, String inputRepeat) {
        this.names = inputName;
        validateInput();

        this.repeat = inputRepeat;
        validateRepeat();
        validateRepeatPositive();
    }

    public List<String> splitInputByComma() {
        String[] splitName = names.split(SPLIT_DELIMITER);
        return Arrays.asList(splitName);
    }

    public int parseRepeatToInt() {
        return Integer.parseInt(repeat);
    }

    private static void validateNameLength(String name) {
        if (isNullName(name) || name.isEmpty() || isLongerThanFive(name)) {
            throw new IllegalArgumentException(LENGTH_ERROR_MESSAGE);
        }
    }

    private static boolean isNullName(String name) {
        if (Objects.isNull(name)) {
            return true;
        }
        return false;
    }

    private static boolean isLongerThanFive(String name) {
        if (name.length() > NAME_LENGTH_LIMIT) {
            return true;
        }
        return false;
    }

    public void validateInput() {
        List<String> list = splitInputByComma();
        if (Objects.isNull(list)) {
            throw new IllegalArgumentException(LENGTH_ERROR_MESSAGE);
        }
        for (String name : list) {
            validateNameLength(name);
        }
    }

    private void validateRepeat() {
        try {
            Integer.parseInt(repeat);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_FORMAT_ERROR_MESSAGE);
        }
    }

    private void validateRepeatPositive() {
        int repeat = parseRepeatToInt();
        if (repeat <= 0) {
            throw new IllegalArgumentException(NOT_POSITIVE_ERROR_MESSAGE);
        }
    }
}