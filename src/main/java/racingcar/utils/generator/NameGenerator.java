package racingcar.utils.generator;

import java.util.Arrays;
import java.util.List;

import racingcar.utils.validator.NameValidator;

public class NameGenerator {
    public static final String DELIMITER = ",";

    public static List<String> generateCarNames(String input) {
        NameValidator.validateNames(input);
        List<String> names = Arrays.asList(input.split(DELIMITER, -1));
        for (String name : names) {
            NameValidator.validateName(name);
        }
        return names;
    }
}
