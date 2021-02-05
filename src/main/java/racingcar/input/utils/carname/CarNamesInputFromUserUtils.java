package racingcar.input.utils.carname;

import java.util.List;
import java.util.Scanner;
import racingcar.input.printer.InputPrinter;
import racingcar.input.utils.carname.validators.CarNameFormatValidatorUtils;
import racingcar.input.utils.carname.validators.CarNamesNotDuplicateValidatorUtils;
import racingcar.input.utils.carname.validators.TwoOrMoreCarNamesValidatorUtils;

public class CarNamesInputFromUserUtils {

    private CarNamesInputFromUserUtils() {
    }

    public static List<String> getAllCarNames(Scanner scanner) {
        InputPrinter.printCarNamesInputMessage();
        String inputCarNames = scanner.next();
        List<String> carNames = CarNamesSplitterUtils.splitCarNames(inputCarNames);
        validateAllCarNames(carNames);
        return carNames;
    }

    private static void validateAllCarNames(List<String> carNames) {
        CarNameFormatValidatorUtils.validateAllCarNamesFormat(carNames);
        TwoOrMoreCarNamesValidatorUtils.validateTwoOrMoreCarNames(carNames);
        CarNamesNotDuplicateValidatorUtils.validateAllCarNamesNotDuplicate(carNames);
    }
}
