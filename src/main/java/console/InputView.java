package console;

import utils.ScannerUtil;
import utils.SplitCarNames;

public class InputView {

    public String[] inputCarNames() {
        final String carNames = ScannerUtil.readLine();
        return SplitCarNames.splitCarNames(carNames);
    }

    public int inputTryCount() {
        final int tryCount = ScannerUtil.readNumber();
        return tryCount;
    }
}
