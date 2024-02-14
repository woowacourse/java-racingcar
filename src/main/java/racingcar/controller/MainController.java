package racingcar.controller;

import java.util.List;
import racingcar.view.InputView;
import racingcar.view.model.ConsoleReader;

public class MainController {
    public void run() {
        List<String> input = InputView.readCarNames(new ConsoleReader());
    }
}
