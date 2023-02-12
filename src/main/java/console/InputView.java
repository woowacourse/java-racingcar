package console;

import java.util.InputMismatchException;
import utils.ScannerUtil;
import utils.SplitCarNames;
import validation.CarNamesValidation;
import validation.TryCountValidation;

public class InputView {

    private final CarNamesValidation carNamesValidation = new CarNamesValidation();

    public String[] inputCarNames() {
        try {
            final String carNames = ScannerUtil.readLine();
            carNamesValidation.validateInputCarNames(carNames);
            return SplitCarNames.splitCarNames(carNames);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return inputCarNames();
        }
    }

    public int inputTryCount() {
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
