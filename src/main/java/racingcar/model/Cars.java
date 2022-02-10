package racingcar.model;

import racingcar.utils.RandomForwardJudgment;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars = new ArrayList<>();

    public Cars(List<String> carNames) {
        carNames.forEach(carName -> cars.add(new Car(carName)));
    }

    public void forward() {
        cars.forEach(car ->
                car.forward(RandomForwardJudgment.canForward()));
    }

    @Override
    public String toString() {
        String result = "";
        for (Car car : cars) {
            result += car;
        }
        return result;
    }
}
