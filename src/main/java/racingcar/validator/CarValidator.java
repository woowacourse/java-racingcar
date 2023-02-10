package racingcar.validator;

import java.util.List;

public interface CarValidator {
    void validateCarName(String name);

    void validateCarNamesSize(List<String> carNames);
}
