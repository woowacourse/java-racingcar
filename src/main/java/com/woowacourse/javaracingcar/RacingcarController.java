package com.woowacourse.javaracingcar;

import com.woowacourse.javaracingcar.domain.RacingcarModel;
import com.woowacourse.javaracingcar.domain.RandomNumberGenerator;
import com.woowacourse.javaracingcar.interfaces.NumberGenerator;
import com.woowacourse.javaracingcar.interfaces.UserInterface;

import java.util.List;

public class RacingcarController {

    private UserInterface ui;

    public RacingcarController(UserInterface ui) {
        this.ui = ui;
    }

    public void play() {
        List<String> carNames = ui.promptUserNames();
        int tries = ui.promptTries();
        NumberGenerator generator = new RandomNumberGenerator();
        RacingcarModel racingcarModel = new RacingcarModel(generator, carNames);

        for (int i = 0; i < tries; i++) {
            ui.printResult(racingcarModel.loop());
        }

        ui.printWinners(racingcarModel.getWinners());
    }
}
