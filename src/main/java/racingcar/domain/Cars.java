package racingcar.domain;

import racingcar.util.NumberGenerator;

import java.util.LinkedHashMap;
import java.util.List;

public class Cars {
    public static final String RANDOM_OUTOF_BOUND = "범위를 초과한 난수입니다.";

    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void playTurn(NumberGenerator random) {
        cars.forEach(car -> {
            car.checkMove(random.generateNumber());
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
