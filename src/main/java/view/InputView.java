package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import domain.Trial;

public class InputView {
    private static final String PRINT_ASK_CARS = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String ERROR_NAME = "두 대 이상의 자동차 이름을 입력해주세요";
    private static final String ERROR_DUPLICATION = "중복되지 않은 자동차를 입력해주세요";
    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;
    private static final String nameLengthErrorMessage = "이름은 1이상 5이하입니다.";
    private static final String DELIMITER = ",";

    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public List<String> askCarNames() {
        System.out.println(PRINT_ASK_CARS);
        try {
            return validateNames(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return askCarNames();
        }
    }

    private List<String> validateNames(String userInput) {
        if (userInput.isBlank() || !userInput.contains(DELIMITER)) {
            throw new IllegalArgumentException(ERROR_NAME);
        }
        return makeNames(userInput);
    }

    private List<String> makeNames(String userInput) {
        List<String> names = new ArrayList<>();
        String[] userInputSplit = userInput.split(DELIMITER);
        for (String inputSplit : userInputSplit) {
            validateDuplication(names, inputSplit);
            validateNameLength(inputSplit);
            names.add(inputSplit.trim());
        }
        return names;
    }

    private void validateDuplication(List<String> names, String inputSplit) {
        if (names.contains(inputSplit)) {
            throw new IllegalArgumentException(ERROR_DUPLICATION);
        }
    }

    private void validateNameLength(String inputSplit) {
        if (inputSplit.trim().length() < MIN_NAME_LENGTH || inputSplit.trim().length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(nameLengthErrorMessage);
        }
    }

    public Trial askTrial() {
        System.out.println("시도할 횟수는 몇회인가요?");
        try {
            Trial trial = new Trial(scanner.nextLine());
            scanner.close();
            return trial;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return askTrial();
        }
    }
}
