package domain;

import java.util.List;

public class RaceResult {
    private final List<Car> winnerCars;
    public static RaceResult of(List<Car> cars){
        Integer maxPosition = cars.
                stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
        List<Car> winnerCars = cars
                .stream()
                .filter(car -> car.getPosition().equals(maxPosition))
                .toList();
        return new RaceResult(winnerCars);
    }
    private RaceResult(List<Car> winnerCars){
        this.winnerCars = winnerCars;
    }

    public List<Car> getWinnerCars() {
        return winnerCars;
    }
}
