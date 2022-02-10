package racingcar;

import static racingcar.InputView.*;

public class InputController {
    public String[] getUserCarNames() {
        String userCarText = scanCarNames();
        return carSplit(userCarText);
    }

    public String[] carSplit(String cars) {
        return cars.split(",");
    }

    public int toInt(String scanNumber) {
        return Integer.parseInt(scanNumber);
    }
}
