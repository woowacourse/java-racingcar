package view;

import static utils.Validator.validateTryTimes;

import java.util.List;
import java.util.Scanner;

public class InputView {

    static Scanner scanner = new Scanner(System.in);

    public static List<String> inputCarNames() {
        return List.of(scanner.nextLine().split(","));
    }

    public static int inputTryTimes() {
        int tryTimes = scanner.nextInt();
        validateTryTimes(tryTimes);
        return tryTimes;
    }
}
