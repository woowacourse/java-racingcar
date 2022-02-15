package racingcar.config;

import racingcar.view.ErrorView;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class ViewConfig {

    public static InputView getInputView() {
        return new InputView(ClientConfig.getInputClient());
    }

    public static OutputView getOutputView() {
        return new OutputView(ClientConfig.getOutputClient());
    }

    public static ErrorView getErrorView() {
        return new ErrorView(ClientConfig.getErrorClient());
    }
}
