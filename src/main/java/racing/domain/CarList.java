package racing.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
