import util.StringUtils;
import view.InputView;

import java.util.List;

public class CarRacingGame {
    private static List<String> getCarNames() {
        String names = InputView.inputCarNames();
        List<String> nameList = StringUtils.parseStringByComma(names);

        for (String name : nameList) {
            if (StringUtils.isCarNameLength(name)) {
                return getCarNames();
            }
        }
        return nameList;
    }

    public static void main(String[] args) {
        getCarNames();
    }
}
