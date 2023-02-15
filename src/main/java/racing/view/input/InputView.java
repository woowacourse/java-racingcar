package racing.view.input;

import java.util.List;
import racing.util.Converter;
import racing.validate.InputVerifier;

import java.util.Scanner;

public class InputView {
    private static final String INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INPUT_COUNT = "시도할 회수는 몇회인가요?";

    static Scanner sc = new Scanner(System.in);

    public static List<String> inputCarName() {
        System.out.println(INPUT_CAR_NAME);
        return Converter.splitInput(sc.next());
    }

    public static int inputCount() {
        System.out.println(INPUT_COUNT);
        String inputCount = InputVerifier.checkInputTypeIsNumber(sc.next());
        return Converter.convertType(inputCount);
    }
}
