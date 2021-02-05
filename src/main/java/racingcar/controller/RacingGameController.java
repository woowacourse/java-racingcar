package racingcar.controller;

import racingcar.model.Car;
import racingcar.utils.RandomUtils;
import racingcar.view.OutputView;

import java.util.ArrayList;

public class RacingGameController {
    public void play(final ArrayList<Car> carsInGame, final int trialNumber) {
        race(carsInGame, trialNumber);
    }

    private void race(final ArrayList<Car> carsInGame, final int trialNumber) {
        for (int i=0; i<trialNumber; i++) {
            for (Car car : carsInGame) {
                car.move(RandomUtils.generateRandomNumber());
                OutputView.printCarInformation(car);
            }
            OutputView.printNewLine();
        }
    }
}
