package racingcar.domain;

import racingcar.util.NumberGenerator;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class Cars {
    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void playTurn(NumberGenerator random) {
        cars.forEach(car -> {
            if(car.canMove(random.generateNumber())) {
                car.proceed();
            }
        });
    }

    public LinkedHashMap<String, String> notifyStatus() {
        LinkedHashMap<String, String> status = new LinkedHashMap<>();
        cars.forEach(car -> status.put(car.currentPosition().get(0), car.currentPosition().get(1)));
        return status;
    }

    public List<String> findWinner() {
        Car carInMaxPosition = cars.get(0);
        List<String> winners = new ArrayList<>();
        int size = cars.size();
        for (int i = 1; i < size - 1; i++) {
            carInMaxPosition = carInMaxPosition.comparePosition(cars.get(i));
        }
        for (Car car : cars) {
            carInMaxPosition.checkMoreWinners(car, winners);
        }
        return winners;
    }
}
