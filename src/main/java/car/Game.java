package car;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private final List<Car> cars;
    public Game(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
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
