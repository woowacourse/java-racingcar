package view;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private InputView() {}

    private static final Scanner sc = new Scanner(System.in);
    public static String inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return sc.nextLine().trim();
    }

    public static int inputMoveCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = sc.nextLine();
        return Integer.parseInt(input);
    }
}
