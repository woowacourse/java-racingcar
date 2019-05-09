/*
 * @(#)CarList.java
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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 게임 한 판에 필요한 Car 들에 대한 처리 클래스
 *
 * @author imkimheejoo
 * @author kwonmc
 * @version 1.0.0
 * @see Car
 */
public class CarList {
    private static final String INPUT_TIMES_EXCEPTION = "이동 횟수는 양수입니다 !";

    private ArrayList<Car> cars = new ArrayList<>();
    private int totalTimes;

    public void addCars(String[] names) {
        for (String name : names) {
            Car car = new Car(name);
            cars.add(car);
        }
    }

    // Test Fixture 를 위한 오버로딩
    public void addCars(String[] names, int[] status) {
        for (int i = 0; i < names.length; i++) {
            Car car = new Car(names[i], status[i]);
            cars.add(car);
        }
    }

    public void setTotalTimes(int totalTimes) {
        if (totalTimes <= 0) {
            throw new IllegalArgumentException(INPUT_TIMES_EXCEPTION);
        }
        this.totalTimes = totalTimes;
    }

    private String toStringOneTime() {
        StringBuilder sb = new StringBuilder();
        for (Car car : cars) {
            sb.append(car.toString());
        }
        sb.append("\n");
        return sb.toString();
    }

    private void playOneTime() {
        for (Car car : cars) {
            car.moveOneTime();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(toStringOneTime()); // 최초 상태 출력

        for (int i = 0; i < totalTimes; i++) {
            playOneTime();
            sb.append(toStringOneTime());
        }

        return sb.toString();
    }

    public List<String> getWinnerList() {
        List<String> result = new ArrayList<>();
        Integer maxStatus = Collections.max(cars).getStatus();
        for (Car car : cars) {
            if (maxStatus.equals(car.getStatus())) {
                result.add(car.getName());
            }
        }
        return result;
    }
}
