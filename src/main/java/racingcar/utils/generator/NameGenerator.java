package racingcar.utils.generator;

import java.util.Arrays;
import java.util.List;

import racingcar.utils.validator.NameValidator;

public class NameGenerator {
    public static final String DELIMITER = ",";

    public static List<String> generateCarNames(String input) {
        NameValidator.validate(input);
        return Arrays.asList(input.split(DELIMITER));
    }
}
