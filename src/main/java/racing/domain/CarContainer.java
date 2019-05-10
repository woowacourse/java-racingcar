/*
 * @(#)CarContainer.java
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
import java.util.Objects;

/**
 * 게임 한 판에 필요한 Car 들에 대한 처리 클래스
 *
 * @author imkimheejoo
 * @author kwonmc
 * @version 1.0.0
 * @see Car
 */
public class CarContainer {
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
        validTotalTime(totalTimes);
        this.totalTimes = totalTimes;
    }

    private void validTotalTime(int totalTimes) {
        if (totalTimes <= 0) {
            throw new IllegalArgumentException(INPUT_TIMES_EXCEPTION);
        }
    }

    public String makeGameResult() {
        StringBuilder sb = new StringBuilder();
        sb.append(toStringOneTime()); // 최초 상태 출력

        for (int i = 0; i < totalTimes; i++) {
            playOneTime();
            sb.append(toStringOneTime());
        }

        return sb.toString();
    }

    private String toStringOneTime() {
        StringBuilder sb = new StringBuilder();
        for (Car car : cars) {
            sb.append(car.positionResult());
        }
        sb.append("\n");
        return sb.toString();
    }

    private void playOneTime() {
        for (Car car : cars) {
            car.moveOneTime(getRandomNumber());
        }
    }

    private int getRandomNumber() {
        return (int) (Math.random() * 10);
    }

    public List<String> searchWinners() {
        List<String> result = new ArrayList<>();
        Integer maxStatus = Collections.max(cars).getPosition();
        for (Car car : cars) {
            if (maxStatus.equals(car.getPosition())) {
                result.add(car.getName());
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
        CarContainer carContainer = (CarContainer) obj;
        for (int i = 0; i < this.cars.size(); i++) {
            if (!this.cars.get(i).equals(carContainer.cars.get(i)))
                return false;
        }
        return true;
    }
}
