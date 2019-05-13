/*
 * @(#)RacingGame.java
 *
 * v 1.0.0
 *
 * 2019.05.09
 *
 * Copyright (c) 2019 MrKwon, imkimheejoo.
 * WoowahanTechCamp, Seoul, KOREA
 * All right Reserved
 */

package racing.domain;

import racing.utils.Helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 게임 한 판에 필요한 Car 들에 대한 처리 클래스
 *
 * @author imkimheejoo
 * @author kwonmc
 * @version 2.0.0
 * @see Car
 */
public class RacingGame {
    private ArrayList<Car> cars = new ArrayList<>();

    public RacingGame(String[] names) {
        for (String name : names) {
            Car car = new Car(name);
            cars.add(car);
        }
    }

    public RacingResult race() {
        List<Car> roundCars = new ArrayList<>();
        cars.forEach(r -> r.movePosition(Helper.getRandomNumber()));
        cars.forEach(r -> roundCars.add(r.copyCar()));
        return new RacingResult(roundCars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        RacingGame carContainer = (RacingGame) obj;
        for (int i = 0; i < this.cars.size(); i++) {
            if (!this.cars.get(i).equals(carContainer.cars.get(i)))
                return false;
        }
        return true;
    }
}
