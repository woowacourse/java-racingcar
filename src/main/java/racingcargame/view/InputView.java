package racingcargame.view;

import java.util.Scanner;

public class InputView {

    private final static Scanner SCANNER  = new Scanner(System.in);

    public static String inputCarNames() {
       System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return SCANNER.nextLine();
    }

    public static int inputTryNumber() {
        System.out.println("시도할 회수는 몇회인가요?");
        int input;
        try {
            input =  SCANNER.nextInt();
        } catch (NumberFormatException e) {
            System.out.println("숫자만 입력해 주세요.");
            input = SCANNER.nextInt();
        }
        return input;
    }
}
