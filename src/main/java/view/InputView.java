package view;

import util.Validator;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String CAR_NAME_DELIMITER = ",";

    private final Scanner sc = new Scanner(System.in);

    public List<String> readCarNames() {
        String[] carNames = sc.nextLine().split(CAR_NAME_DELIMITER);

        return Arrays.asList(carNames);
    }

    public Integer readMovingCount() {
        String input = sc.nextLine();

        Validator.validateMovingCountInput(input);

        return Integer.parseInt(input);
    }
}
