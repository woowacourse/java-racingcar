package com.woowacourse.javaracingcar;

import com.woowacourse.javaracingcar.domain.Car;
import com.woowacourse.javaracingcar.domain.CarDto;
import com.woowacourse.javaracingcar.domain.RacingcarGame;
import com.woowacourse.javaracingcar.interfaces.InputView;
import com.woowacourse.javaracingcar.interfaces.NumberGenerator;
import com.woowacourse.javaracingcar.interfaces.OutputView;

import java.util.List;


public class RacingcarController {
    private final RacingcarGame game;

    public RacingcarController(final List<String> carNames, final NumberGenerator numberGenerator) {
        this.game = new RacingcarGame(numberGenerator, RacingcarUtil.createCars(carNames));
    }

    public List<CarDto> play() {
        return game.loop();
    }

    public List<CarDto> retrieveWinners() {
        return game.getWinners();
    }

    @Override
    public String toString() {
        return String.format("RacingcarController { game: %s }", game);
    }
}
