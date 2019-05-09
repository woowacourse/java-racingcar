package com.woowacourse.javaracingcarwithoutif;

import com.woowacourse.javaracingcar.interfaces.NumberGenerator;
import com.woowacourse.javaracingcarwithoutif.domain.RacingcarModel;
import com.woowacourse.javaracingcarwithoutif.interfaces.UserInterface;

import java.util.List;

public class RacingcarController {
    private UserInterface ui;
    private NumberGenerator numberGenerator;

    public RacingcarController(UserInterface ui, NumberGenerator numberGenerator) {
        this.ui = ui;
        this.numberGenerator = numberGenerator;
    }

    public void play() {
        List<String> carNameList = ui.promptUserNames();
        int tries = ui.promptTries();
        RacingcarModel racingcarModel = new RacingcarModel(numberGenerator, carNameList);

        for (int i = 0; i < tries; i++) {
            ui.printResult(racingcarModel.loop());
        }

        ui.printWinners(racingcarModel.getWinners());
    }
}
