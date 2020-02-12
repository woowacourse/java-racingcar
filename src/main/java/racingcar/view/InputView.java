package racingcar.view;

import racingcar.util.InputHandler;

import java.util.Scanner;

public class InputView {

    private static final Scanner sc = new Scanner(System.in);

    public static String[] inputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return validateNames(sc.nextLine());
    }

    private static String[] validateNames(String s) {
        String[] names = s.split(",");

        InputHandler.validateCarCount(names.length);

        for (String name : names) {
            InputHandler.validateNullOrEmpty(name);
            InputHandler.validateNameLength(name);
        }
        return names;
    }

    public static int inputGameRound() {
        System.out.println("시도할 회수는 몇회인가요? (최대 10회)");
        return validateRound(sc.nextLine());
    }

    private static int validateRound(String inputRound) {
        int round = InputHandler.validateNumber(inputRound);
        InputHandler.validateCount(round);
        return round;
    }
}
