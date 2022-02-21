package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private static final String NOTHING_NAME_ERROR_MASSAGE = "자동차 이름들이 존재하지 않음";
    private static final int MIN_POSITION = 0;

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

    public void move(final MoveStrategy moveStrategy) {
        for (Car car : carList) {
            car.move(moveStrategy.isMovable());
        }
    }

    public List<Car> getCarList() {
        return new ArrayList<>(carList);
    }

    public int getMaxPosition() {
        int maxPosition = MIN_POSITION;

        for (Car car : carList) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }

        return maxPosition;
    }
}
