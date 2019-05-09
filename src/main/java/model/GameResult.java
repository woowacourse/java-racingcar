package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameResult {
    public List<String> getWinners(List<Car> cars) {
        List<String> winners = new ArrayList<>();

        int maxCarPosition = Collections.max(cars).getPosition();
        for(Car car : cars){
            addWinners(winners, maxCarPosition, car);
        }

        return winners;
    }

    private void addWinners(List<String> winners, int maxCarPosition, Car car) {
        if(car.getPosition() == maxCarPosition){
            winners.add(car.getName());
        }
    }
}
