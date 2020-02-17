/*
 * Copyright (c) 2020 by 티거, 제이미
 * All rights reserved.
 *
 * @author      티거, 제이미
 * @version     1.0
 * @date        12 Feb 2020
 *
 */

package racingcar.domain;

import racingcar.view.OutputView;

public class RacingGame {

    private final Cars cars;
    private final int tryCount;

    public RacingGame(Cars cars, int tryCount) {
        this.cars = cars;
        this.tryCount = tryCount;
    }

    public void getRacingProgress() {
        for (int i = 0; i < tryCount; i++) {
            playRacing();
        }
    }

    private void playRacing() {
        for (Car car : cars.getCars()) {
            car.move(RandomNumber.getRandomNo());
            OutputView.printCarPosition(car.getName(), car.getPosition());
        }
        OutputView.printNextLine();
    }

    public String getWinner() {
        return Winner.getWinner(cars);
    }
}
