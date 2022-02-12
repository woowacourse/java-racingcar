package racingcar.view;

import racingcar.utils.Validator;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String input = scanner.nextLine();
        Validator.checkCarNames(input);
        return input;
    }

    public static int getCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = scanner.nextLine();
        Validator.checkCount(input);
        return Integer.parseInt(input);
    }
}
