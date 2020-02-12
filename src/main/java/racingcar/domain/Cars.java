package racingcar.domain;

import racingcar.util.NumberGenerator;

import java.util.LinkedHashMap;
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

    public LinkedHashMap<String, Integer> notifyStatus() {
        LinkedHashMap<String, Integer> status = new LinkedHashMap<>();
        cars.forEach(car -> {
            status.put(car.getName(), car.getPosition());
        });
        return status;
    }
}
