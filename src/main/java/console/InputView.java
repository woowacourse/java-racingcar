package console;

import java.util.InputMismatchException;
import utils.ScannerUtil;
import validation.CarInfoValidation;
import validation.TryCountValidation;

public class InputView {

    public static String inputCarsName() {
        try {
            final String carsName = ScannerUtil.readLine();
            CarInfoValidation.validateCar(carsName);
            return carsName;
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return inputCarsName();
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
