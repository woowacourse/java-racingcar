package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.Names;
import racingcar.domain.Trial;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    public void start() {
        try {
            OutputView.enterCarNames();
            Names names = InputView.getNames();
            Cars cars = new Cars(names);

            OutputView.enterTrials();
            Trial trial = InputView.getTrial();



        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
        }
    }
}
