package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Winner {

    private final List<String> winners;

    public Winner(Cars cars) {
        this.winners = new ArrayList<>();
        Car maxDistanceCar = Collections.max(cars.getCars());
        findWinner(cars, maxDistanceCar.getDistance());
    }

    private void findWinner(Cars cars, int maxDistance) {
        for (int i = 0; i < cars.getCarsSize(); i++) {
            addWinner(cars, maxDistance, i);
        }
    }

    private void addWinner(Cars cars, int maxDistance, int i) {
        if(cars.getCar(i).getDistance() == maxDistance){
            winners.add(cars.getCar(i).getCarName());
        }
    }

    public List<String> getWinners() {
        return winners;
    }
}
