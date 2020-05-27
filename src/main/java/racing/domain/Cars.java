package racing.domain;

import com.sun.javafx.UnmodifiableArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(final String[] carNames) {
        cars = Arrays.stream(carNames)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public Cars(final Car... cars){
        this.cars = new ArrayList<>(Arrays.asList(cars));
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> findWinners() {
        return cars.stream()
                .filter(car -> car.getPosition() == findMaxPosition())
                .collect(Collectors.toList());
    }

    private int findMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .getAsInt();
    }
}
