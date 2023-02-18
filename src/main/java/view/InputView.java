package view;

import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final String CAR_NAME_DELIMITER = ",";

    static Scanner scanner = new Scanner(System.in);

    public static List<String> inputCarNames() {
        return List.of(scanner.nextLine().split(CAR_NAME_DELIMITER));
    }

    public static int inputTryTimes() {
        return scanner.nextInt();
    }
}
