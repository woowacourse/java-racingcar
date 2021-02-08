package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Winners {
    private Winners() {
    }

    private static List<Car> winners = new ArrayList<>();

    public static void allocateWinners() {
        Car maxPositionCar = Cars.getMaxPositionCar();
        for (Car car : Cars.getCars()) {
            allocateWinner(car, maxPositionCar);
        }
    }

    public static List<String> getWinnersNames() {
        return winners.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private static void allocateWinner(Car car, Car maxPositionCar) {
        if (car.isMaxPosition(maxPositionCar)) {
            winners.add(car);
        }
    }
}

