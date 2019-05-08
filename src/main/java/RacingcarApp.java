import view.InputView;

import java.util.List;
import java.util.Random;

import static util.StringUtil.*;

public class RacingcarApp {
    private static int BOUND_NUMBER = 10;


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

    private int makeRandomNumber() {
        Random random = new Random();

        return random.nextInt(BOUND_NUMBER);
    }
}
