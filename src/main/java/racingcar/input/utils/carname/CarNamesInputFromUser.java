package racingcar.input.utils.carname;

import java.util.List;
import java.util.Scanner;
import racingcar.input.printer.InputPrinter;
import racingcar.input.utils.carname.validators.CarNameFormatValidatorUtils;
import racingcar.input.utils.carname.validators.CarNamesNotDuplicateValidatorUtils;
import racingcar.input.utils.carname.validators.TwoOrMoreCarNamesValidatorUtils;

public class CarNamesInputFromUser {
    private final Scanner scanner;

    public CarNamesInputFromUser(Scanner scanner) {
        this.scanner = scanner;
    }

    public List<String> getAllCarNames() {
        InputPrinter.printCarNamesInputMessage();
        String inputCarNames = scanner.next();
        List<String> carNames = CarNamesSplitterUtils.splitCarNames(inputCarNames);
        validateAllCarNames(carNames);
        return carNames;
    }

    private void validateAllCarNames(List<String> carNames) {
        CarNameFormatValidatorUtils.validateAllCarNamesFormat(carNames);
        TwoOrMoreCarNamesValidatorUtils.validateTwoOrMoreCarNames(carNames);
        CarNamesNotDuplicateValidatorUtils.validateAllCarNamesNotDuplicate(carNames);
    }
}
