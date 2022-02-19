package racingcar.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ConsoleInputView implements InputView {


    private static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String COUNT_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String DELIMITER = ",";

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public List<String> getCarNames() {
        System.out.println(CAR_NAME_INPUT_MESSAGE);
        String input = scanner.nextLine();
        return Arrays.asList(input.split(DELIMITER));
    }

    @Override
    public int getCount() {
        System.out.println(COUNT_INPUT_MESSAGE);
        String input = scanner.nextLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요");
        }
    }
}
