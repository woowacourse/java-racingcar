package racingcar.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String inputCarNames(Scanner scanner) {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String input = scanner.nextLine();
        printEmptyLine();
        return input;
    }

    public static int inputRoundCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        int input = scanner.nextInt();
        printEmptyLine();
        return input;
    }

    private static void printEmptyLine() {
        System.out.println();
    }
}
