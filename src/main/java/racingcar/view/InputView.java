package racingcar.view;

import racingcar.domain.Cars;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static racingcar.domain.Name.validateBlankInName;
import static racingcar.domain.Name.validateNameLength;
import static racingcar.domain.Round.validateIntegerNumber;
import static racingcar.domain.Round.validateNonNegativeNumber;

public class InputView {
    private static final String COMMA = ",";

    public static List<String> takeNameInput(Scanner scanner) {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
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
        System.out.println("시도할 회수는 몇회인가요?");
        String numberOfRoundsInput = scanner.nextLine();
        validateNumberOfRoundsInput(numberOfRoundsInput);
        return numberOfRoundsInput;
    }

    private static void validateNumberOfRoundsInput(String numberOfRoundsInput) {
        validateIntegerNumber(numberOfRoundsInput);
        validateNonNegativeNumber(numberOfRoundsInput);
    }
}