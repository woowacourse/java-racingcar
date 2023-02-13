package racing.view.input;

import racing.validate.InputVerifier;

import java.util.Scanner;

public class InputView {

    private static final String INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INPUT_COUNT = "시도할 회수는 몇회인가요?";


    static Scanner sc = new Scanner(System.in);

    public static String inputCarName() {
        System.out.println(INPUT_CAR_NAME);
        return sc.next();
    }

    public static String inputCount() {
        System.out.println(INPUT_COUNT);
        return InputVerifier.checkInputTypeIsNumber(sc.next());
    }
}
