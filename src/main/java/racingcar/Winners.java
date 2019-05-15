package racingcar;

import java.util.*;

public class Winners {
    private List<String> listOfWinners = new ArrayList<>();

    Winners(Cars cars) {
        List<Car> carsState = cars.getCars();
        int maxPosition = decideMaxPosition(carsState);
        decideWinners(carsState, maxPosition);
    }

    public int decideMaxPosition(List<Car> cars) {
        int max = 0;
        for (Car car : cars) {
            max = car.findMax(max);
        }
        return max;
    }

    public void decideWinners(List<Car> cars, int maxPosition) {
        for (Car car : cars) {
            addWinners(car, maxPosition);
        }
    }

    public void addWinners(Car car, int maxPosition) {
        if (car.isSameMaxPosition(maxPosition)) {
            listOfWinners.add(car.getName());
        }
    }

    public String getWinners() {
        return String.join(", ", listOfWinners);
    }

}
