package racingcar;

import static racingcar.InputView.scanCarNames;
import static racingcar.InputView.scanTryCount;

public class InputController {
    public String[] getUserCarNames() throws RuntimeException {
        String userCarText = scanCarNames();
        return carSplit(userCarText);
    }

    public int getUserTryCount() throws RuntimeException {
        String userTryCount = scanTryCount();
        return toInt(userTryCount);
    }

    public String[] carSplit(String cars) throws RuntimeException {
        for (String carName : cars.split(",")) {
            InputValidator.validateName(carName);
        }
        return cars.split(",");
    }

    public int toInt(String scanNumber) throws RuntimeException {
        InputValidator.validateTryCount(scanNumber);
        return Integer.parseInt(scanNumber);
    }
}
