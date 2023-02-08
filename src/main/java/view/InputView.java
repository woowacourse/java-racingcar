package view;

import java.util.List;
import java.util.Scanner;
import util.CarNameValidator;
import util.Util;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final InputView instance = new InputView();

    public static InputView getInstance() {
        return instance;
    }

    private InputView() {
    }

    public List<String> readCarNames() {
        System.out.println(Message.INPUT_CARS.message);
        String input = Util.removeSpace(scanner.nextLine());
        List<String> names = Util.splitByComma(input);
        new CarNameValidator().validate(names);
        return names;
    }

    private enum Message {
        INPUT_CARS("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");

        private final String message;

        Message(String message) {
            this.message = message;
        }
    }
}
