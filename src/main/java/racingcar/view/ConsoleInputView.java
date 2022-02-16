package racingcar.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ConsoleInputView implements InputView{
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public List<String> getCarNames() {
        System.out.println(CAR_NAME_INPUT_MESSAGE);
        String input = scanner.nextLine();
        return Arrays.asList(input.split(DELIMITER));
    }

    @Override
    public int getCount() {
        System.out.println(COUNT_INPUT_MESSAGE);
        String input = scanner.nextLine();
        return Integer.parseInt(input);
    }
}
