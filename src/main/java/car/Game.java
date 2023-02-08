package car;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private static final int INITIAL_TRIAL_COUNT = 0;

    private final List<Car> cars;
    private final int trialCount;

    public Game(List<Car> cars) {
        this(cars, INITIAL_TRIAL_COUNT);
    }

    public Game(List<Car> cars, int trialCount) {
        this.cars = new ArrayList<>(cars);
        this.trialCount = trialCount;
    }

    public List<Car> getWinners() {
        int maxPosition = findMaxPosition();
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if(car.getPosition() > maxPosition){
                maxPosition = car.getPosition();
                winners = new ArrayList<>(List.of(car));
            }
            if(car.getPosition()==maxPosition){
                winners.add(car);
            }
        }
        return winners;
    }
    private Integer findMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }
        return maxPosition;
    }
}
