package racingcar.view;

import java.util.Scanner;

import static racingcar.view.OutputConstant.*;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String DELIMITER = ",";

    public String[] inputCarName() {
        System.out.println(INPUT_CAR_NAME);
        String input = scanner.nextLine();
        return input.split(DELIMITER);
    }

    public String inputGameTime() {
        System.out.println(INPUT_TRY_COUNT);
        String input = scanner.nextLine();
        return input;
    }
}
