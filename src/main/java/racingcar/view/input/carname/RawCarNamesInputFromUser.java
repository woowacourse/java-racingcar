package racingcar.view.input.carname;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import racingcar.view.input.carname.printer.CarNamesInputFromUserPrinter;

public class RawCarNamesInputFromUser {
    public static final String CAR_NAMES_DELIMITER = ",";

    public static List<String> getAllCarNames(Scanner scanner) {
        CarNamesInputFromUserPrinter.printCarNamesInputMessage();
        String inputCarNames = scanner.nextLine();
        return Collections.unmodifiableList(
            Arrays.stream(inputCarNames.split(CAR_NAMES_DELIMITER))
                .collect(Collectors.toList())
        );
    }
}
