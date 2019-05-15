package racingcar;

import java.util.*;

public class Winners {
    private List<String> listOfWinners;

    Winners(Cars cars) {
        List<Car> carsState = cars.getCars();
        int maxPosition = decideMaxPosition(carsState);
        this.listOfWinners = getResultWinners(carsState, maxPosition);
    }

    public int decideMaxPosition(List<Car> cars) {
        int max = 0;
        for (Car car : cars) {
            max = car.findMax(max);
        }
        return max;
    }

    public List<String> getResultWinners(List<Car> cars, int maxPosition) { //TODO get winners
        List<String> listOfWinners = new ArrayList<>();
        for (Car car : cars) {
            findWinner(listOfWinners, car, maxPosition);
        }
        return listOfWinners;
    }

    public void findWinner(List<String> listOfWinners, Car car, int maxPosition) {
        if (car.isSameMaxPosition(maxPosition)) {
            listOfWinners.add(car.getName());
        }
    }

    public String getWinnerNames() {
        return String.join(", ", listOfWinners);
    }
}
