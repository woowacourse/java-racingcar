package view;

import static utils.Constant.CAR_NAME_DELIMITER;

import java.util.List;
import java.util.Scanner;

public class InputView {

    static Scanner scanner = new Scanner(System.in);

    public static List<String> inputCarNames() {
        return List.of(scanner.nextLine().split(CAR_NAME_DELIMITER));
    }

    public static int inputTryTimes() {
        return scanner.nextInt();
    }
}
