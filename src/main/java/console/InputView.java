package console;

import utils.ScannerUtil;
import utils.SplitCarNames;

public class InputView {

    public String[] inputCarNames() {
        final String carNames = ScannerUtil.readLine();
        return SplitCarNames.splitCarNames(carNames);
    }

    public int inputTryCount() {
        return ScannerUtil.readNumber();
    }
}
