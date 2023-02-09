package car.view;

import java.util.Scanner;
import java.util.regex.Pattern;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public String[] inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.nextLine().split(",");
    }

    public int inputTrialCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = scanner.nextLine();
        validateInteger(input);
        validateTrialCountUnderMaxInteger(input);
        return Integer.parseInt(input);
    }

    private void validateTrialCountUnderMaxInteger(String input) {
        if (input.length() >= 10) {
            throw new IllegalArgumentException("시도 횟수는 999999999이하여야 합니다.");
        }
    }

    private void validateInteger(String input) {
        if (!Pattern.matches("\\d+", input)) {
            throw new IllegalArgumentException("시도 횟수는 정수여야 합니다");
        }
    }
}
