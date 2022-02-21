package carracinggame.controller;

import carracinggame.domain.Times;
import carracinggame.view.InputView;
import carracinggame.view.OutputView;

public class TimesController {

    public Times getTimes() {
        OutputView.printWhatTimes();
        return makeTimes(InputView.getInput());
    }

    public Times makeTimes(String input) {
        Times times;
        try {
            times = new Times(input);
        } catch (IllegalArgumentException e) {
            OutputView.println(e.getMessage());
            return getTimes();
        }
        return times;
    }
}
