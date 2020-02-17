package racinggame.domain;

import racinggame.view.InputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Names {
    public static final String LENGTH_ERROR_MESSAGE = "이름의 길이는 1자 이상, 5자" +
            " 이하만 가능합니다.";
    private static final String SPLIT_DELIMITER = ",";
    private static final int NAME_LENGTH_LIMIT = 5;
    private List<String> names;

    public Names() {
        this(InputView.inputName());
    }

    public Names(String inputNames) {
        names = splitInputByComma(inputNames);
        validateInput();
    }

    public List<Car> makeCars() {
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
        return cars;
    }

    public static List<String> splitInputByComma(String inputNames) {
        String[] splitName = inputNames.split(SPLIT_DELIMITER);
        return Arrays.asList(splitName);
    }

    public void validateInput() {
        if (Objects.isNull(names)) {
            throw new IllegalArgumentException(LENGTH_ERROR_MESSAGE);
        }
        for (String name : names) {
            validateNameLength(name);
        }
    }

    private static void validateNameLength(String name) {
        if (isNullName(name) || name.isEmpty() || isLongerThanFive(name)) {
            throw new IllegalArgumentException(LENGTH_ERROR_MESSAGE);
        }
    }

    private static boolean isNullName(String name) {
        return Objects.isNull(name);
    }

    private static boolean isLongerThanFive(String name) {
        return name.length() > NAME_LENGTH_LIMIT;
    }
}