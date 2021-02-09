package racingcar.view;

import racingcar.domain.Cars;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static racingcar.domain.Name.validateBlankInName;
import static racingcar.domain.Name.validateNameLength;
import static racingcar.domain.RacingGame.validateIntegerNumber;
import static racingcar.domain.RacingGame.validatePositiveNumber;

public class InputView {
    private static final String COMMA = ",";

    public static List<String> takeNameInput(Scanner scanner) {
        String input = scanner.nextLine();
        List<String> names = Arrays.asList(input.split(COMMA));

        validateNamesInput(names);
        return names;
    }

    private static void validateNamesInput(List<String> names) {
        Cars.validateDuplicateNames(names);
        names.forEach(name -> {
            validateBlankInName(name);
            validateNameLength(name);
        });
    }

    public static String takeNumberOfRoundsInput(Scanner scanner) {
        String numberOfRoundsInput = scanner.nextLine();
        validateNumberOfRoundsInput(numberOfRoundsInput);
        return numberOfRoundsInput;
    }

    private static void validateNumberOfRoundsInput(String numberOfRoundsInput) {
        validateIntegerNumber(numberOfRoundsInput);
        validatePositiveNumber(numberOfRoundsInput);
    }
}