package com.woowacourse.javaracingcar;

import com.woowacourse.javaracingcar.domain.*;
import com.woowacourse.javaracingcar.interfaces.InputView;
import com.woowacourse.javaracingcar.interfaces.NumberGenerator;
import com.woowacourse.javaracingcar.interfaces.OutputView;

import java.util.List;


public class RacingcarController {
    private final RacingcarGame game;

    public RacingcarController(final List<String> carNames, final NumberGenerator numberGenerator) {
        this.game = new RacingcarGame(numberGenerator, RacingcarUtil.createCars(carNames), new RacingcarGameRuleImpl());
    }

    public PlayingCars play() {
        return game.loop();
    }

    public WinnerGroup retrieveWinners() {
        return game.getWinners();
    }

    @Override
    public String toString() {
        return String.format("RacingcarController { game: %s }", game);
    }
}
