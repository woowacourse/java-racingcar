import view.InputView;

import java.util.List;

import static util.StringUtils.*;

public class CarRacingGame {
    private static List<String> getCarNames() {
        String names = InputView.inputCarNames();
        List<String> nameList = parseStringByComma(names);

        for (String name : nameList) {
            if (isCarNameLength(name)) {
                return getCarNames();
            }
        }
        return nameList;
    }

    public static void main(String[] args) {
        getCarNames();
    }
}
