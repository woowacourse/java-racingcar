package racingcar.view;

import java.util.*;

import static racingcar.domain.Car.*;
import static racingcar.domain.Cars.DUPLICATE_NAME_ERROR_MESSAGE;
import static racingcar.domain.RacingGame.*;

public class InputView {
    private static final String COMMA = ",";

    public static List<String> takeNameInput(Scanner scanner) {
        String input = scanner.nextLine();
        List<String> names = Arrays.asList(input.split(COMMA));

        validateDuplicateName(names);
        names.forEach(name -> {
            validateBlankInName(name);
            validateNameLength(name);
        });
        return names;
    }

    private static void validateBlankInName(String name) {
        if (name.contains(BLANK)) {
            throw new IllegalArgumentException(BLANK_ERROR_MESSAGE);
        }
    }

    private static void validateNameLength(String name) {
        if (name.length() < MINIMUM_NAME_LENGTH || MAXIMUM_NAME_LENGTH < name.length()) {
            throw new IllegalArgumentException(NAME_LENGTH_ERROR_MESSAGE);
        }
    }

    private static void validateDuplicateName(List<String> names) {
        Set<String> nameSet = new HashSet<>(names);
        if (nameSet.size() != names.size()) {
            throw new IllegalArgumentException(DUPLICATE_NAME_ERROR_MESSAGE);
        }
    }

    public static int takeNumberOfRoundsInput(Scanner scanner) {
        String numberOfRoundsInput = scanner.nextLine();
        validateIntegerNumber(numberOfRoundsInput);
        int numberOfRounds = Integer.parseInt(numberOfRoundsInput);
        validatePositiveNumber(numberOfRounds);
        return numberOfRounds;
    }

    private static void validateIntegerNumber(String numberOfRoundsInput) {
        try {
            Integer.parseInt(numberOfRoundsInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER_ERROR_MESSAGE);
        }
    }

    private static void validatePositiveNumber(int numberOfRounds) {
        if (numberOfRounds < MINIMUM_NUMBER_OF_ROUNDS) {
            throw new IllegalArgumentException(UNAVAILABLE_NUMBER_OF_ROUNDS_MESSAGE);
        }
    }
}