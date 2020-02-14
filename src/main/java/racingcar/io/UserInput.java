package racingcar.io;

import java.util.Scanner;

public class UserInput {
    private static final String INPUT_CARNAME_ALERT = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INPUT_ITERATION_ALERT = "시도할 횟수는 몇 회인가요?";
    private static final Scanner scanner = new Scanner(System.in);

    public static String inputCarsName() {
        System.out.println(INPUT_CARNAME_ALERT);
        return scanner.nextLine();
    }

    public static int inputIteration() {
        System.out.println(INPUT_ITERATION_ALERT);
        return scanner.nextInt();
    }
}
