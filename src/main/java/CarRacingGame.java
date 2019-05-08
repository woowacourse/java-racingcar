import view.InputView;

import java.util.List;

import static util.StringUtils.*;

public class CarRacingGame {
    private static List<String> getCarNames() {
        String names = InputView.inputCarNames();
        List<String> nameList = parseStringByComma(names);

        for (String name : nameList) {
            if (!isCarNameLength(name)) {
                System.out.println("각 자동차의 이름을 5자 이하로 입력해주세요.");
                return getCarNames();
            }
        }
        return nameList;
    }

    public static void main(String[] args) {
        getCarNames();
    }
}
