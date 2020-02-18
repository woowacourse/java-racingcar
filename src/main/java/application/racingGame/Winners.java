package application.racingGame;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Winners {

    public List<String> getNamesOfWinners(List<Car> cars) {
        List<String> winners = new ArrayList<>();
        int maxPosition;
        maxPosition = findMaxPosition(cars);
        getWinnerName(cars, winners, maxPosition);
        return winners;
    }

    private void getWinnerName(List<Car> cars, List<String> winners, int maxPosition) {
        for (Car car : cars) {
            if (isWinnerCar(maxPosition, car)) {
                winners.add(car.getName());
            }
        }
    }

    private boolean isWinnerCar(int maxPosition, Car car) {
        return car.isSameMaxPosition(maxPosition);
    }

    private int findMaxPosition(List<Car> cars) {
        Car maxPositionCar = cars.stream().max(Comparator.comparing(Car::getPosition)).get();
        return maxPositionCar.getPosition();
    }

}
