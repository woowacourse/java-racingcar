package console;

import java.util.InputMismatchException;
import utils.ScannerUtil;
import utils.SplitCarNames;
import validation.CarNamesValidation;
import validation.TryCountValidation;

public class InputView {

    public static String[] inputCarNames() {
        try {
            final String carNames = ScannerUtil.readLine();
            CarNamesValidation.validateInputCarNames(carNames);
            return SplitCarNames.splitCarNames(carNames);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return inputCarNames();
        }
    }

    public static int inputTryCount() {
        try {
            final int tryCount = ScannerUtil.readNumber();
            TryCountValidation.validateTryCount(tryCount);
            return tryCount;
        } catch (IllegalArgumentException | InputMismatchException exception) {
            System.out.println(exception.getMessage());
            return inputTryCount();
        }
    }
}
