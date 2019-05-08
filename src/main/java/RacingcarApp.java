import util.StringUtil;
import view.InputView;

import java.util.List;

public class RacingcarApp {
    public static void main(String[] args) {
        String str = InputView.inputCarNames();
        List<String> list = StringUtil.parseStringByComma(str);
    }
}
