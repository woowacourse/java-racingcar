package service;

import domain.Cars;
import domain.GameCount;

public class RacingGameService {
    private GameCount count;
    private Cars cars;

    private void init(String namesInput, String countInput) {
        this.cars = Cars.from(namesInput);
        this.count = new GameCount(countInput);
    }
}
