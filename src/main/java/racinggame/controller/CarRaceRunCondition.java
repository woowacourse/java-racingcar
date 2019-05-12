package racinggame.controller;

import racinggame.util.RandomNumber;

public class CarRaceRunCondition implements RunCondition {
    @Override
    public int runOrStop() {
        return RandomNumber.generateRandomNumber();
    }
}
