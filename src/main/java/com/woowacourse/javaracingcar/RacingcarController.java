package com.woowacourse.javaracingcar;

import com.woowacourse.javaracingcar.domain.RacingcarModel;
import com.woowacourse.javaracingcar.interfaces.NumberGenerator;
import com.woowacourse.javaracingcar.interfaces.UserInterface;

import java.util.List;


public class RacingcarController {

    private final UserInterface ui;
    private final NumberGenerator numberGenerator;

    public RacingcarController(final UserInterface ui, final NumberGenerator numberGenerator) {
        this.ui = ui;
        this.numberGenerator = numberGenerator;
    }

    public void play() {
        final List<String> carNames = ui.promptUserNames();
        final int tries = ui.promptTries();
        final RacingcarModel racingcarModel = new RacingcarModel(numberGenerator, carNames);

        for (int i = 0; i < tries; i++) {
            ui.printResult(racingcarModel.loop());
        }

        ui.printWinners(racingcarModel.getWinners());
    }
}
