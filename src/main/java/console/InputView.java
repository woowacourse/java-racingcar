package console;

import utils.ScannerUtil;
import validation.CarInfoValidation;
import validation.TryCountValidation;

import java.util.InputMismatchException;

public class InputView {

    public static String inputCarName() {
        try {
            final String carInfo = ScannerUtil.readLine();
            CarInfoValidation.validateCar(carInfo);
            return carInfo;
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return inputCarName();
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
