package racingcar.domain;

import racingcar.util.NumberGenerator;
import racingcar.util.RandomNumberGenerator;

import java.util.HashMap;
import java.util.List;

import static racingcar.Utils.checkMove;

public class Cars {
    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void playTurn(NumberGenerator random) {
        cars.forEach(car -> {
            if (checkMove(random.generateNumber())) {
                car.proceed();
            }
        });
    }

    public HashMap<String, Integer> notifyStatus() {
        HashMap<String, Integer> status = new HashMap<>();
        cars.forEach(car -> {
            status.put(car.getName(), car.getPosition());
        });
        return status;
    }
}
