package com.woowacourse.javaracingcar;

import com.woowacourse.javaracingcar.domain.Car;
import com.woowacourse.javaracingcar.interfaces.NumberGenerator;
import com.woowacourse.javaracingcar.interfaces.UserInterface;

import java.util.ArrayList;
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
        RacingcarModel racingcarModel = new RacingcarModel(generator, createCars(carNames));

        for (int i = 0; i < tries; i++) {
            ui.printResult(racingcarModel.loop());
        }

        ui.printWinners(racingcarModel.getWinners());
    }

    public List<Car> createCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String s : carNames) {
            cars.add(new Car(s));
        }

        return cars;
    }
}
