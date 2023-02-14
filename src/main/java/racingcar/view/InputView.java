package racingcar.view;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final String CAR_NAME_DELIMITER = ",";
    private static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String TRIES_INPUT_MESSAGE = "시도할 횟수는 몇회인가요?";
    private static final Scanner sc = new Scanner(System.in);

    public static List<String> inputCarNames() {
        System.out.println(CAR_NAME_INPUT_MESSAGE);
        String input = sc.nextLine();

        return splitInputByDelimiter(input);
    }

    public static int inputTries() {
        try {
            System.out.println(TRIES_INPUT_MESSAGE);
            return sc.nextInt();
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }

    private static List<String> splitInputByDelimiter(String input) {
        return Arrays.stream(input.split(CAR_NAME_DELIMITER))
                .map(String::trim)
                .collect(Collectors.toList());

    }
    
}
