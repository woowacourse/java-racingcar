package racingcar.view;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import racingcar.domain.Cars;
import racingcar.domain.Name;
import racingcar.domain.TryNumber;

public class InputView {

    private static final String CAR_NAME_DELIMITER = ",";

    private InputView() {
    }

    public static Cars getCars(final Scanner scanner) {
        OutputView.printCarNameReadMessage();
        try {
            String inputValue = scanner.nextLine();
            return new Cars(getParseNames(inputValue));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return getCars(scanner);
        }
    }

    private static List<Name> getParseNames(String inputValue) {
        List<String> parsedInputValue = Arrays.asList(inputValue.split(CAR_NAME_DELIMITER));
        Set<String> set = new HashSet<>();
        for (String value : parsedInputValue) {
            if (set.contains(value)) {
                throw new IllegalArgumentException("[ERROR] 자동차 이름은 중복이 불가능합니다.");
            }
            set.add(value);
        }
        return parsedInputValue.stream().map(Name::new).collect(Collectors.toList());
    }

    public static TryNumber getTryNumber(final Scanner scanner) {
        OutputView.printAttemptNumberReadMessage();
        try {
            String inputValue = scanner.nextLine();
            return new TryNumber(Integer.parseInt(inputValue));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return getTryNumber(scanner);
        }
    }

}
