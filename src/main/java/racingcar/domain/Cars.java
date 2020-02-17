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

    public void playTurn(NumberGenerator number) {
        cars.forEach(car -> {
            if(car.canMove(number.generateNumber())) {
                car.proceed();
            }
        });
    }

    public LinkedHashMap<String, Integer> notifyStatus() {
        LinkedHashMap<String, Integer> status = new LinkedHashMap<>();
        cars.forEach(car -> status.put(car.getName(), car.getPosition()));
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
