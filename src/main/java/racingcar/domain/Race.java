package racingcar.domain;

import java.util.List;
import java.util.Map;

public class Race {
    private final Competitors competitors;
    private final Movable strategy;

    public Race(List<String> names, Movable strategy) {
        this.competitors = new Competitors(names);
        this.strategy = strategy;
    }

    public Race(Map<String, Integer> carInfo, Movable strategy) {
        this.competitors = new Competitors(carInfo);
        this.strategy = strategy;
    }

    public List<Car> startEachRound() {
        return competitors.startEachRound(strategy);
    }

    public List<Car> getWinners() {
        return competitors.getWinners();
    }
}