package racingcar.domain;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import racingcar.domain.car.Car;
import racingcar.domain.car.Name;

public class RacingGameFactory {

    private static final String NAME_SPLIT_DELIMITER = ",";
    private static final Pattern NUMBER_PATTERN = Pattern.compile("[0-9]+");

    private RacingGameFactory() {
    }

    public static Cars generateCars(final String names) {
        final String[] parsedNames = names.split(NAME_SPLIT_DELIMITER, -1);
        return new Cars(Arrays.stream(parsedNames)
            .map(Name::new)
            .map(Car::new)
            .collect(Collectors.toList()));
    }

    public static Trial generateTrial(final String trial) {
        validateNumber(trial);
        try {
            int trialNumber = Integer.parseInt(trial);
            return new Trial(trialNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Integer 범위 밖의 입력입니다.");
        }
    }

    private static void validateNumber(final String input) {
        if (!NUMBER_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }
    }
}
