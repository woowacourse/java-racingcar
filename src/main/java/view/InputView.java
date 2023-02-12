package view;

import java.util.List;
import java.util.Scanner;
import util.Util;
import util.validator.MoveCountValidator;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final InputView instance = new InputView();
    private static final int MIN_CAR_NUMBER = 2;


    public static InputView getInstance() {
        return instance;
    }

    private InputView() {
    }

    public List<String> readCarNames() {
        System.out.println(Message.INPUT_CARS.message);
        String input = Util.removeSpace(scanner.nextLine());
        List<String> names = Util.split(input);
        validateCarNumber(names);
        return names;
    }

    private void validateCarNumber(List<String> names) {
        if (names.size() < MIN_CAR_NUMBER) {
            throw new IllegalArgumentException(Message.EXCEPTION_CAR_NUMBER.message);
        }
    }

    public int readMoveCount() {
        System.out.println(Message.INPUT_MOVE_COUNT.message);
        String input = Util.removeSpace(scanner.nextLine());
        new MoveCountValidator().validate(input);
        return Integer.parseInt(input);
    }

    private enum Message {
        EXCEPTION_CAR_NUMBER("2개 이상의 자동차를 입력해 주세요."),
        INPUT_CARS("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."),
        INPUT_MOVE_COUNT("시도할 회수는 몇회인가요?");

        private final String message;

        Message(String message) {
            this.message = message;
        }
    }
}
