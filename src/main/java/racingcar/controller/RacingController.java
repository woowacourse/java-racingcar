package racingcar.controller;

import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.view.dto.CarNames;
import racingcar.view.dto.TrialTimes;

public class RacingController {
    private final InputView inputView;
    private final OutputView outputView;

    public RacingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void init() {

    }

    private void requestCarNames() {
        CarNames carNames = inputView.getCarNames();
        TrialTimes trialTimes = inputView.getTrialTimes();
    }


}
