package com.woowacourse.javaracingcar;

import com.woowacourse.javaracingcar.domain.RandomNumberGenerator;
import com.woowacourse.javaracingcar.interfaces.InputView;
import com.woowacourse.javaracingcar.interfaces.OutputView;

public class AppMain {

    public static void main(String[] args) {
        InputView input = new ConsoleInputView();
        OutputView output = new ConsoleOutputView();
        RacingcarController controller = new RacingcarController(input.promptUserNames(), new RandomNumberGenerator());
        int tries = input.promptTries();

        for (int i = 0; i < tries; i++) {
            output.printResult(controller.play());
        }

        output.printWinners(controller.retrieveWinners());
    }
}
