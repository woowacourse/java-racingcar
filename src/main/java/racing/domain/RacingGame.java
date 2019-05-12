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
 * @version 1.0.0
 * @see Car
 */
public class RacingGame {
    private ArrayList<Car> cars = new ArrayList<>();
    private int execution;

    public RacingGame(String[] carNames, int execution) {
        addCars(carNames);
        this.execution = execution;
    }

    private void addCars(String[] names) {
        for (String name : names) {
            Car car = new Car(name);
            cars.add(car);
        }
    }

    public RacingGameResult playRacing() {
        RacingGameResult racingGameResult = new RacingGameResult();
        for (int i = 0; i < execution; i++) {
            playOneTime();
            List<Car> list=new ArrayList<>();
            cars.forEach(r->list.add(r.copyCar()));
            RacingResult racingResult = new RacingResult(list);
            racingGameResult.addResult(racingResult);
        }
        return racingGameResult;
    }
    private void playOneTime() {
        for (Car car : cars) {
            car.movePosition(Helper.getRandomNumber());
        }
    }

    // Test Fixture 를 위한 오버로딩
//    void addCars(String[] names, int[] status) {
//        for (int i = 0; i < names.length; i++) {
//            Car car = new Car(names[i], status[i]);
//            cars.add(car);
//        }
//    }

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
