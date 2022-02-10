package racingcar.config;

import java.util.Scanner;
import racingcar.view.InputView;

public class ViewConfig {

    public static InputView getInputView() {
        return new InputView(new Scanner(System.in));
    }
}
