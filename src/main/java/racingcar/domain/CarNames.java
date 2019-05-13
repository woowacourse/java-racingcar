package racingcar.domain;

import java.util.Arrays;
import java.util.List;

public class CarNames {
    final static int MIN_CAR_NAME_LENGTH = 1;
    final static int MAX_CAR_NAME_LENGTH = 5;
    private String[] names;

    public CarNames(String name) throws IllegalArgumentException {
        validateNullCarName(name);

        name.replaceAll(" ", "");
        String[] names = name.split(",");
        List<String> carNames = Arrays.asList(names);

        validateMinimalCarName(names);

        validateDuplicateCarName(carNames);

        validateMaximamCarName(names);

        this.names = names;
    }

    public String[] getName() {
        return names;
    }

    private void validateNullCarName(String name) throws IllegalArgumentException{
        if (name == null){
            throw new IllegalArgumentException("null은 입력으로 들어올 수 없습니다.\n다시 입력해 주세요.");
        }
    }

    private void validateDuplicateCarName(List<String> carNames) throws IllegalArgumentException {
        if (carNames.stream().distinct().count() != carNames.size()) {
            throw new IllegalArgumentException("중복된 이름은 안됩니다.\n다시 입력해 주세요.");
        }
    }

    private void validateMinimalCarName(String[] names) throws IllegalArgumentException {
        if (names.length < MIN_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("이름 갯수는 1글자 이상이여야 합니다.\n다시 입력해 주세요.");
        }

        for (String name : names) {
            if (name.length() <= 0) {
                throw new IllegalArgumentException("글자 수는 1글자 이상이여야 합니다.\n다시 입력해 주세요.");
            }
        }

    }

    private void validateMaximamCarName(String[] names) throws IllegalArgumentException {
        for (String name : names) {
            if (name.length() > MAX_CAR_NAME_LENGTH || name.length() <= 0) {
                throw new IllegalArgumentException("글자 수는 5글자 이내여야 합니다.\n다시 입력해 주세요.");
            }
        }
    }

}
