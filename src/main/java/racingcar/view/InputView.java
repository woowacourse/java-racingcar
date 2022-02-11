package racingcar.view;

import java.io.Console;
import java.util.Scanner;

import racingcar.domain.Count;

public class InputView {
    private static final String CAR_DELIMITER = ",";
    private static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INPUT_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";

    private static final Scanner scanner = new Scanner(System.in);

    public static String[] getCarNames() {
        System.out.println(INPUT_CAR_NAMES_MESSAGE);
        String input = scanner.nextLine();
        return input.split(CAR_DELIMITER);
    }

    public static Count getCount() {
        System.out.println(INPUT_COUNT_MESSAGE);
        return new Count(scanner.nextLine());
    }
}
