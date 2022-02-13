package racingcar.view;

import racingcar.utils.Validator;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return getCarNames(scanner.nextLine());
    }

    private static String getCarNames(String input) {
        try {
            Validator.checkInput(input);
            return input;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getCarNames();
        }
    }

    public static int getCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = scanner.nextLine();
        Validator.checkCount(input);
        return Integer.parseInt(input);
    }
}
