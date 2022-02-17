package racingcar.view;

import racingcar.domain.car.Name;
import racingcar.util.StringValidator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String FORMAT_PATTERN = "(([a-zA-Z0-9ㄱ-ㅎㅏ-ㅣ가-힣]+)(,)?)+";
    private static final String SPLIT_DELIMITER = ",";
    private static final Scanner scanner = new Scanner(System.in);


    public static List<Name> inputNamesUi() {
        OutputView.printInputNamesUi();

        String input = scanner.nextLine();
        StringValidator.validateFormatByRegex(input, FORMAT_PATTERN);

        List<Name> names = mapStringListToNameList(splitInput(input));
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

    private static List<String> splitInput(String input) {
        return Arrays.stream(input.split(SPLIT_DELIMITER))
                .collect(Collectors.toList());
    }

    private static List<Name> mapStringListToNameList(List<String> stringList) {
        return stringList.stream()
                .map(Name::from)
                .collect(Collectors.toList());
    }
}
