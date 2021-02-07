package racingcar.input.carname;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import racingcar.input.carname.printer.CarNamesInputFromUserPrinter;

public class RawCarNamesInputFromUser {
    private final CarNamesInputFromUserPrinter carNamesInputFromUserPrinter;
    private final Scanner scanner;
    public static final String CAR_NAMES_DELIMITER = ",";

    public RawCarNamesInputFromUser(Scanner scanner) {
        this.carNamesInputFromUserPrinter = new CarNamesInputFromUserPrinter();
        this.scanner = scanner;
    }

    public List<String> getAllCarNames() {
        carNamesInputFromUserPrinter.printCarNamesInputMessage();
        String inputCarNames = scanner.nextLine();
        return Arrays.stream(inputCarNames.split(CAR_NAMES_DELIMITER))
            .collect(Collectors.toList());
    }
}
