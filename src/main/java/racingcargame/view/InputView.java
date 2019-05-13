package racingcargame.view;

import racingcargame.model.Validation;

import java.util.Scanner;

public class InputView {
    private static final String NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)";
    private static final String COUNT_OF_ROUND_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";

    private static Scanner scanner = new Scanner(System.in);

    public static String readNames() {
        System.out.println(NAME_INPUT_MESSAGE);
        try {
            return scanner.nextLine();
        } catch (Exception e) {
            return readNames();
        }
    }

    public static int readCountOfRound() {
        System.out.println(COUNT_OF_ROUND_INPUT_MESSAGE);
        try {
            int input = scanner.nextInt();
            Validation.validNegativeNumber(input);
            return input;
        } catch (Exception e) {
            return readCountOfRound();
        }
    }
    
}
