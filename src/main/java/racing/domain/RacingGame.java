/*
 * @(#)InputView.java
 *
 * v 2.0.0
 *
 * 2019.05.11
 *
 * Copyright (c) 2019 MrKwon, imkimheejoo.
 * WoowahanTechCamp, Seoul, KOREA
 * All right Reserved
 */

package racing.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * 게임 한 판에 필요한 Car 들에 대한 클래스
 *
 * @author imkimheejoo
 * @author kwonmc
 * @version 2.0.0
 * @see Car
 */
public class RacingGame {
    private List<Car> cars;

    public RacingGame(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public RacingGame runEachGame() {
        for (Car car : cars) {
            Rule rule = new Rule();
            car.moveByRandomNumber(rule);
        }
        return this;
    }

    public String getWinners() {
        Car maxCar = getMaxPosition(this.cars);
        Winner winner = new Winner();

        for (Car car : cars) {
            if (car.isSamePosition(maxCar)) {
                winner.add(car);
            }
        }

        return winner.getWinners();
    }

    private Car getMaxPosition(List<Car> cars) {
        return Collections.max(cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        RacingGame racingGame = (RacingGame) obj;
        for (int i = 0; i < this.cars.size(); i++) {
            if (!this.cars.get(i).equals(racingGame.cars.get(i)))
                return false;
        }
        return true;
    }
}
