package racingcar.view;

import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INPUT_TRY_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final Scanner scanner = new Scanner(System.in);


    private InputView() {
    }

    public static int inputTryCount() {
        System.out.println(INPUT_TRY_COUNT_MESSAGE);
        return nextInt();
    }

    private static int nextInt() {
        String line = scanner.nextLine();
        return Integer.parseInt(line);
    }

    public static List<String> inputCarName() {
        System.out.println(INPUT_CAR_NAME_MESSAGE);
        return List.of(scanner.nextLine().split(","));
    }

    public static void close() {
        scanner.close();
    }
}
