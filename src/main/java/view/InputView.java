package view;

import exception.BlankInputException;
import exception.BlankNameException;
import exception.DuplicateCarNameException;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class InputView {

    private static final String NAME_SEPARATOR = ",";
    private static final int NAME_MIN_LENGTH = 1;
    private static final int NAME_MAX_LENGTH = 5;
    private static final String INPUT_CAR_NAMES_MESSAGE =
            "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INPUT_ROUND_MESSAGE =
            "시도할 회수는 몇회인가요?";

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public Set<String> inputCarsName() {
        print(INPUT_CAR_NAMES_MESSAGE);

        String input = input();
        validateBlank(input);

        return mapToValidCarsName(input);
    }

    private Set<String> mapToValidCarsName(String input) {
        String[] inputCarsName = input.split(NAME_SEPARATOR);
        LinkedHashSet<String> carsName = Arrays.stream(inputCarsName)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        validateNameDuplication(inputCarsName.length, carsName.size());
        carsName.forEach(this::validateCarName);
        return carsName;
    }

    private void validateNameDuplication(int nameSize, int carSize) {
        if (nameSize != carSize) {
            throw new DuplicateCarNameException();
        }
    }

    private void validateCarName(String carName) {
        if (carName.isBlank() || !validateNameLength(carName)) {
            throw new BlankNameException();
        }
    }

    private boolean validateNameLength(String name) {
        int length = name.length();

        return length >= NAME_MIN_LENGTH && length <= NAME_MAX_LENGTH;
    }

    public String inputRound() {
        print(INPUT_ROUND_MESSAGE);
        return input();
    }

    private void validateBlank(String input) {
        if (input.isBlank()) {
            throw new BlankInputException();
        }
    }

    private void print(String message) {
        System.out.println(message);
    }

    private String input() {
        return scanner.nextLine();
    }
}
