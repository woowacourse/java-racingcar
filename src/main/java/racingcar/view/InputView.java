package racingcar.view;

import java.util.Arrays;
import java.util.Scanner;
import racingcar.Validation;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);
    private static final String SEPARATOR = ",";

    public static String[] carNames() {
        try {
            System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
            return inputCarNames();
        } catch (IllegalArgumentException e) {
            OutputView.error(e.getMessage());
            return carNames();
        }
    }

    private static String[] inputCarNames() {
        String carNames = input();
        Validation.validateSeparator(carNames);
        String[] cars = carNames.split(SEPARATOR);
        Validation.validateCarCount(cars);
        Arrays.stream(cars).forEach(Validation::validateNameLength);

        return cars;
    }

    public static int tryCount() {
        try {
            System.out.println("시도할 횟수는 몇회인가요?");
            return inputTryCount();
        } catch (IllegalArgumentException e) {
            OutputView.error(e.getMessage());

            return tryCount();
        }
    }

    private static int inputTryCount() throws IllegalArgumentException {
        String inputTryCount = input();

        try {
            Validation.validateParseInt(inputTryCount);
        } catch (NumberFormatException e) {
            OutputView.error(e.getMessage());
        }
        int tryCount = Integer.parseInt(inputTryCount);
        Validation.validateTryCount(tryCount);

        return tryCount;
    }

    private static String input() {
        return scanner.nextLine();
    }
}
