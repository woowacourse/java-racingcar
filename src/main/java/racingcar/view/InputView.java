package racingcar.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {

    private static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INPUT_TRY_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";

    private static final Scanner CONSOLE = new Scanner(System.in);

    public static String inputCarNames() {
        System.out.println(INPUT_CAR_NAMES_MESSAGE);
        return CONSOLE.nextLine();
    }

    public static int inputTryCount() {
        try {
            System.out.println(INPUT_TRY_COUNT_MESSAGE);
            return CONSOLE.nextInt();
        } catch (InputMismatchException e) {
            throw new NumberFormatException("시도횟수는 숫자이어야 합니다.");
        }
    }
}
