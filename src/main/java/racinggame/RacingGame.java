package racinggame;

import java.util.List;

public class RacingGame {

    private final List<Car> cars;
    private final MoveCondition moveCondition;

    private RacingGame(List<Car> cars, MoveCondition moveCondition) {
        this.cars = cars;
        this.moveCondition = moveCondition;
    }

    public static RacingGame of(List<Car> cars, MoveCondition moveCondition) {
        if (cars.size() < 2) {
            throw new RuntimeException();
        }

        if (cars.stream().distinct().count() != cars.size()) {
            throw new RuntimeException();
        }

        return new RacingGame(cars, moveCondition);
    }

    public void moveAll() {
        cars.forEach(car -> car.move(moveCondition));
    }

    public List<Car> getCars() {
        return cars;
    }
}
