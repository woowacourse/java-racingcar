package car.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Game {
    private static final int INITIAL_MAX_POSITION = 0;
    private final List<Car> cars;
    private final MoveChance moveChance;

    public Game(List<Car> cars, MoveChance moveChance) {
        this.cars = new ArrayList<>(cars);
        this.moveChance = moveChance;
    }
    public List<CarDto> getWinnersDto(){
        return findWinners().stream().map(Car::getCarDto).collect(Collectors.toList());
    }
    private List<Car> findWinners() {
        int maxPosition = findMaxPosition();
        return cars.stream()
                .filter(car -> car.hasSamePositionWith(maxPosition))
                .collect(Collectors.toList());
    }

    private int findMaxPosition() {
        int maxPosition = INITIAL_MAX_POSITION;
        for (Car car : cars) {
            maxPosition = car.selectMaxPosition(maxPosition);
        }
        return maxPosition;
    }

    public void playOnce() {
        for (Car car : cars) {
            car.move(moveChance);
        }
    }
    public List<CarDto> getCarsDto(){
        return cars.stream().map(Car::getCarDto).collect(Collectors.toList());
    }
}
