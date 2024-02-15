package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static List<String> enterCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String rawCarNames = scanner.nextLine();
        return validateCarNames(rawCarNames);
    }

    private static List<String> validateCarNames(String rawCarNames){
        validateBlankInput(rawCarNames);
        List<String> carNames = split(rawCarNames);
        return carNames.stream().map(name -> name.trim()).toList();
    }

    private static List<String> split(String rawCarNames) {
        return Arrays.stream(rawCarNames.split(","))
                .toList();
    }

    private static void validateBlankInput(String carNames) {
        if (carNames == null || carNames.isEmpty()) {
           throw new IllegalArgumentException("빈 문자열을 입력할 수 없습니다. 다시 입력해주세요.");
        }
    }

    public static int enterCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String rawCount = scanner.nextLine();
        return validateCount(rawCount);
    }

    private static int validateCount(String rawCount) {
        try {
            return Integer.parseInt(rawCount);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("정수를 입력해주세요.");
        }
    }
}
