package view;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner sc = new Scanner(System.in);
    public static List<String> inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String input = sc.nextLine().trim();
        validateLastComma(input);
        return List.of(input.split(","));
    }

    private static void validateLastComma(String input) {
        if (input.endsWith(",")) {
            throw new IllegalArgumentException("이름은 1글자 이상 5글자 이하만 가능합니다.");
        }
    }

    public static int inputMoveCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = sc.nextLine();
        return Integer.parseInt(input);
    }
}
