package model;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    List<Car> cars;
    List<String> winners;
    int lapCount;

    RacingGame(int lapCount) {
        cars = new ArrayList<>();
        winners = new ArrayList<>();
        this.lapCount = lapCount;
    }

    void run() {
        for (int i = 0; i < lapCount; i++) {
            runLap();
        }
    }

    private void runLap() {
        Racing racing = new Racing();
        for (Car car : cars) {
            racing.move(car);
        }
    }
}
