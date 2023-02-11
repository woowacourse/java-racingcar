package view;

import java.util.List;
import java.util.Scanner;
import util.CarNameValidator;
import util.MoveCountValidator;
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
        List<String> names = Util.split(input);
        new CarNameValidator().validate(names);
        return names;
    }

    public int readMoveCount() {
        System.out.println(Message.INPUT_MOVE_COUNT.message);
        String input = Util.removeSpace(scanner.nextLine());
        new MoveCountValidator().validate(input);
        return Integer.parseInt(input);
    }

    private enum Message {
        INPUT_CARS("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."),
        INPUT_MOVE_COUNT("시도할 회수는 몇회인가요?");

        private final String message;

        Message(String message) {
            this.message = message;
        }
    }
}
