package com.woowacourse.javaracingcar;

import com.woowacourse.javaracingcar.domain.RacingcarModel;
import com.woowacourse.javaracingcar.interfaces.InputView;
import com.woowacourse.javaracingcar.interfaces.NumberGenerator;
import com.woowacourse.javaracingcar.interfaces.OutputView;

import java.util.List;


public class RacingcarController {

    private final OutputView outputView;
    private final InputView inputView;
    private final NumberGenerator numberGenerator;

    public RacingcarController(final InputView input, final OutputView output, final NumberGenerator numberGenerator) {
        inputView = input;
        outputView = output;
        this.numberGenerator = numberGenerator;
    }

    public void play() {
        final List<String> carNames = inputView.promptUserNames();
        final int tries = inputView.promptTries();
        final RacingcarModel racingcarModel = new RacingcarModel(numberGenerator, carNames);

        for (int i = 0; i < tries; i++) {
            outputView.printResult(racingcarModel.loop());
        }

        outputView.printWinners(racingcarModel.getWinners());
    }
}
