package com.woowacourse.javaracingcar;

import com.woowacourse.javaracingcar.domain.RacingcarGame;
import com.woowacourse.javaracingcar.domain.RacingcarGameRuleImpl;
import com.woowacourse.javaracingcar.domain.RandomNumberGenerator;
import com.woowacourse.javaracingcar.interfaces.InputView;
import com.woowacourse.javaracingcar.interfaces.OutputView;

public class AppMain {

    public static void main(String[] args) {
        InputView input = new ConsoleInputView();
        OutputView output = new ConsoleOutputView();
        RacingcarGame game = new RacingcarGame(
            RacingcarUtil.createCars(input.promptUserNames()),
            new RacingcarGameRuleImpl(new RandomNumberGenerator()));
        int tries = input.promptTries();

        output.printResultTitle();
        output.printResult(game.loop(tries));
    }
}
