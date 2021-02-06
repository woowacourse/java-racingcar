package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.utils.RandomUtils;
import racingcar.view.OutputView;

public class RacingGameController {
    private int maxDistance;

    public void play(final Cars carsInGame, final int trialNumber) {
        OutputView.printOutputMessage();
        for (int i = 0; i < trialNumber; i++) {
            singleMove(carsInGame);
        }
        OutputView.printWinner(carsInGame.getWinner(maxDistance));
    }

    private void singleMove(final Cars carsInGame) {
        for (Car car : carsInGame.getCars()) {
            maxDistance = Math.max(car.move(RandomUtils.generateRandomNumber()), maxDistance);
            OutputView.printCarInformation(car);
        }
        OutputView.printNewLine();
    }
}

