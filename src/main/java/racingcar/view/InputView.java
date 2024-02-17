package racingcar.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private final Scanner SCANNER = new Scanner(System.in);

    public List<String> readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String input = SCANNER.nextLine();
        validateInput(input);
        return Arrays.stream(input.split(","))
                .toList();
    }

    public int readTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = SCANNER.nextLine();
        return parseInt(input);
    }

    public void finishReadingInput() {
        SCANNER.close();
    }

    private static void validateInput(String input) {
        if (input == null || input.isEmpty() || input.endsWith(",")) {
            String message = "자동차 이름 입력은 공백이거나 구분자(,)로 끝날 수 없습니다.";
            throw new IllegalArgumentException(message);
        }
    }

    private int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            String message = "입력 횟수는 숫자 형식이어야 합니다.";
            throw new IllegalArgumentException(message);
        }
    }
}
