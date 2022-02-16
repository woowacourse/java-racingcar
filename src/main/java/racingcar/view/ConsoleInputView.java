package racingcar.view;

import racingcar.utils.Validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ConsoleInputView implements InputView{
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public List<String> getCarNames() {
        System.out.println(CAR_NAME_INPUT_MESSAGE);
        String input = scanner.nextLine();
        Validator.checkCarNames(input);
        return new ArrayList<>(Arrays.asList(input.split(DELIMITER)));
    }

    @Override
    public int getCount() {
        System.out.println(COUNT_INPUT_MESSAGE);
        String input = scanner.nextLine();
        Validator.checkCount(input);
        return Integer.parseInt(input);
    }
}
