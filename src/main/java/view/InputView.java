package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private final String CAR_NAME_DELIMITER = ",";

    private final Scanner sc = new Scanner(System.in);

    public List<String> readCarNames() {
        String[] carNames = sc.nextLine().split(CAR_NAME_DELIMITER);

        return Arrays.asList(carNames);
    }

    public int readTryCount() {
        String tryCountInput = sc.nextLine();
        MovingCountValidator.validateTryCountInput(tryCountInput);

        return Integer.parseInt(tryCountInput);
    }
}
