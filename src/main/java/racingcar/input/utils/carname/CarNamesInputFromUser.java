package racingcar.input.utils.carname;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import racingcar.input.printer.CarNamesInputFromUserPrinter;

public class CarNamesInputFromUser {
    private final CarNamesInputFromUserPrinter carNamesInputFromUserPrinter;
    private final Scanner scanner;
    public static final String CAR_NAMES_DELIMITER = ",";

    public CarNamesInputFromUser(Scanner scanner) {
        this.carNamesInputFromUserPrinter = new CarNamesInputFromUserPrinter();
        this.scanner = scanner;
    }

    public List<String> getAllCarNames() {
        carNamesInputFromUserPrinter.printCarNamesInputMessage();
        String inputCarNames = scanner.next();
        return Arrays.stream(inputCarNames.split(CAR_NAMES_DELIMITER))
            .collect(Collectors.toList());
    }
}
