package racingcar.view;

import java.util.Scanner;

public class InputView {
    public static String askAndReceiveCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        Scanner scanner = new Scanner(System.in);
        String names = scanner.nextLine();
        return names;
    }

    public static int askAndReceiveTurns() {
        System.out.println("시도할 횟수는 몇회인가요?: ");
        Scanner reader = new Scanner(System.in);
        int userInput = reader.nextInt();
        return userInput;
    }
}
