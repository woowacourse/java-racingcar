package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

import racingcar.util.RandomUtil;

public class Cars {
    private static final String NOTHING_NAME_ERROR_MASSAGE = "자동차 이름들이 존재하지 않음";
    private final List<Car> carList = new ArrayList<>();

    public Cars(final List<String> names) {
        validateNames(names);
        for (String name : names) {
            carList.add(new Car(name));
        }
    }

    private void validateNames(final List<String> names) {
        if (names.isEmpty()) {
            throw new IllegalArgumentException(NOTHING_NAME_ERROR_MASSAGE);
        }
    }

    public void move() {
        for (Car car : carList) {
            car.move(RandomUtil.generateRandomNumber());
        }
    }

    public List<Car> getCarList() {
        return carList;
    }

    public int getMaxPosition() {
        int maxPosition = 0;

        for (Car car : carList) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }

        return maxPosition;
    }
}
