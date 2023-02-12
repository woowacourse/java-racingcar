package racingcar.view;

import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final Scanner sc = new Scanner(System.in);

    public static String inputCarNames() {
        System.out.println(CAR_NAME_INPUT_MESSAGE);
        return sc.nextLine();
    }
}
