package racingcar.view;

import racingcar.domain.car.Name;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String SPLIT_DELIMITER = ",";
    private static final Scanner scanner = new Scanner(System.in);

    public static List<Name> inputNamesUi() {
        OutputView.printInputNamesUi();

        List<Name> names = Arrays.stream(scanner.nextLine().split(SPLIT_DELIMITER))
                .map(Name::from)
                .collect(Collectors.toList());

        validateDuplicated(names);

        return names;
    }

    public static String inputTryCountUi() {
        OutputView.printInputTryCountUi();
        return scanner.nextLine();
    }

    private static void validateDuplicated(List<Name> names) {
        if (names.size() != names.stream().distinct().count()) {
            throw new IllegalArgumentException("중복된 이름이 있습니다.");
        }
    }
}
