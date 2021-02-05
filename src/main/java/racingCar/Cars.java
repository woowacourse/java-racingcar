package racingCar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    public static List<Car> cars = new ArrayList<>();

    public static void carAdd(Car car){
        cars.add(car);
    }

    public static List<String> findWinners(int max){
        return cars.stream()
                .filter(car -> car.isWinner(max))
                .map(car -> car.getName())
                .collect(Collectors.toList());
    }

    public static int getSize() {
        return cars.size();
    }

    public static List<Car> getCars() {
        return cars;
    }
}
