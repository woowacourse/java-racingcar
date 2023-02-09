package car;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private final List<Car> cars;
    private final MoveChance moveChance;

    public Game(List<Car> cars, MoveChance moveChance) {
        this.cars = new ArrayList<>(cars);
        this.moveChance = moveChance;
    }

    public List<Car> findWinners() {
        int maxPosition = findMaxPosition();
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car);
            }
        }
        return winners;
    }

    private Integer findMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            if (car.isFartherThan(maxPosition)) {
                maxPosition = car.getPosition();
            }
        }
        return maxPosition;
    }

    public void playOnce() {
        for (Car car : cars) {
            car.move(moveChance);
        }
    }
}
