package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private final String NOT_A_NUMBER = "시도할 횟수는 숫자를 입력해야 합니다.";

    private final Scanner scanner = new Scanner(System.in);

    public List<String> readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");

        return splitByComma(scanner.nextLine());
    }

    public int readTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");

        String input = scanner.nextLine();
        validate(input);

        return Integer.parseInt(input);
    }

    private List<String> splitByComma(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private void validate(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_A_NUMBER);
        }
    }
}
