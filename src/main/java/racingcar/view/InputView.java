package racingcar.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력해주세요.(이름은 쉼표(,)를 기준으로 구분합니다.)");
        return inputValue();
    }

    public static String inputRound() {
        System.out.println("시도할 회수는 몇회인가요?");
        return InputView.inputValue();
    }

    private static String inputValue() {
        return scanner.nextLine();
    }
}