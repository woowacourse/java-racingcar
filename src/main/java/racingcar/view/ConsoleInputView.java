package racingcar.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ConsoleInputView implements InputView {
    private static final String NAME_DELIMITER = ",";
    private final Scanner scanner = new Scanner(System.in);

    public List<String> inputCarNames() {
        String inputCarNames = scanner.nextLine();
        return Arrays.stream(inputCarNames.split(NAME_DELIMITER))
                .collect(Collectors.toList());
    }
}
