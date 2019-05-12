package racinggame.controller;

import racinggame.domain.Car;

public class CarAlwaysRun implements RunCondition {
    @Override
    public int runOrStop() {
        return Car.MOVE_THRESHOLD;
    }
}
