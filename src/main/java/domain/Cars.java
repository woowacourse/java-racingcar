package domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> cars;

    public Cars(List<String> carNames) {
        // 자동차 개수 검증
        if (carNames.size() <= 1) {
            throw new IllegalArgumentException();
        }

        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        this.cars = cars;
    }

    public void tryMove() {
        for (Car car : cars) {
            car.tryMove(RandomNumberGenerator.generate());
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getCarsMaxPosition() {
        int maxPosition = -1;
        for (Car car : cars) {
            maxPosition = Math.max(car.getPosition(), maxPosition);
        }

        return maxPosition;
    }
}
