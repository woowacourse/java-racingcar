package racingcar;

import racingcar.controller.Controller;
import racingcar.domain.RandomNumberPicker;
import racingcar.view.ConsoleOutput;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.view.UserInput;

public class Application {
    public static void main(String[] args) {
        Controller controller = new Controller(
                new RandomNumberPicker(),
                new UserInput(),
                new OutputView(new ConsoleOutput()),
                new InputView(new ConsoleOutput()));
        controller.raceTracks();
    }
}
