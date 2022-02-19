package carracinggame.controller;

import carracinggame.domain.Times;
import carracinggame.view.InputView;
import carracinggame.view.OutputView;

public class TimesController {

    public int getTimes() {
        OutputView.printWhatTimes();
        String input = InputView.getInput();
        return makeTimes(input);
    }

    public int makeTimes(String input) {
        try {
            Times.isRightTimes(input);
        } catch (IllegalArgumentException e) {
            OutputView.printTimesError();
            return getTimes();
        }
        return Integer.parseInt(input);
    }
}
