import view.InputView;

import java.util.List;

import static util.StringUtil.*;

public class RacingcarApp {
    public static void main(String[] args) {
        List<String> carNames = getCarNames();
        int tryNumber = InputView.inputTryNum();
    }

    private static List<String> getCarNames() {
        String str = InputView.inputCarNames();
        List<String> list = parseStringByComma(str);

        for (String carName : list) {
            if (!isCarNameLength(carName)) {
                return getCarNames();
            }
        }
        return list;
    }
}
