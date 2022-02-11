package racingcar.view;

import java.util.Scanner;

public class InputView {

    public static String requestCarNameInput() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return InputView.requestUserInput();
    }

    public static String requestTotalRoundsInput() {
        System.out.println("시도할 회수는 몇회인가요?");
        return InputView.requestUserInput();
    }

    private static String requestUserInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
