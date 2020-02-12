package racingcargame.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }


    public int getMaxPosition() {
        int result = 0;
        for (Car car : cars) {
            if (car.getPosition() > result) {
                result = car.getPosition();
            }
        }
        return result;
    }

    public List<String> getCarsInSamePositionWith(int position) {
        return cars.stream()
                .filter(car -> car.isSamePositionWith(position))
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
