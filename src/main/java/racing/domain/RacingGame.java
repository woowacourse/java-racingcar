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
    private static final int RAND_INT_UPPER_BOUND = 10;

    private List<Car> cars;

    public RacingGame(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public RacingGame runEachGame() {
        for (Car car : cars) {
            int rand = getRandomNumber();
            car.moveByRandomNumber(rand);
        }
        return this;
    }

    private int getRandomNumber() {
        return (int) (Math.random() * RAND_INT_UPPER_BOUND);
    }

    public String[] getWinners() {
        int maxPosition = getMaxPosition(this.cars);
        String[] result = new String[countWinnerNumber(maxPosition)];

        int index = 0;
        for (Car car : cars) {
            if (car.isSamePosition(maxPosition)) {
                result[index] = car.getName();
                index++;
            }
        }

        return result;
    }

    private int getMaxPosition(List<Car> cars) {
        return Collections.max(cars).getPosition();
    }

    private int countWinnerNumber(int number) {
        int result = 0;
        for (Car car : cars) {
            if (car.isSamePosition(number)) {
                result++;
            }
        }
        return result;
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
