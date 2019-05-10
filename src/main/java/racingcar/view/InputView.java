package racingcar.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner input = new Scanner(System.in);

    public static String inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return input.nextLine();
    }

    public static int inputNumberOfTrial() throws IllegalArgumentException {
        System.out.println("시도할 회수는 몇회인가요?");
        return Integer.parseInt(input.nextLine().trim());
    }
}