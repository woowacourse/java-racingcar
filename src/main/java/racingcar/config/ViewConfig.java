package racingcar.config;

import java.util.Scanner;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class ViewConfig {

    public static InputView getInputView() {
        return new InputView(new Scanner(System.in));
    }

    public static OutputView getOutputView() {
        return new OutputView();
    }
}
