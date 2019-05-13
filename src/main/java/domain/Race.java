package domain;

import util.Util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 * Created by Heebg
 * User: heebg
 * Date: 2019-05-08
 */
public class Race {
    private List<Car> raceCars;
    private HashMap<String, Integer> roundCounts;
    private static final String ROUND_COUNT = "roundCount";
    private static final String NOW_ROUND_COUNT = "nowRoundCount";

    public Race(List<Car> raceCars) {
        this(raceCars, Const.MIN_ROUND_COUNT + 1);
    }

    public Race(List<Car> raceCars, int roundCount) {
        Util.checkRoundCountRange(roundCount);
        this.raceCars = raceCars;
        this.roundCounts = new HashMap<>();
        this.roundCounts.put(ROUND_COUNT, roundCount);
        this.roundCounts.put(NOW_ROUND_COUNT, Const.MIN_ROUND_COUNT);
    }

    public List<String> getRaceCarInfo() {
        List<String> carNames = new ArrayList<>();
        for (Car car : raceCars) {
            carNames.add(car.toString());
        }
        return carNames;
    }

    public Race moveAllCars() {
        while (hasNextRound()) {
            moveAllCarOneTime();
        }
        return this;
    }

    public Winners winners() {
        if(hasNextRound()){
            throw new IllegalArgumentException();
        }
        return new Winners(raceCars);
    }

    public boolean hasNextRound() {
        if (roundCounts.get(NOW_ROUND_COUNT) < roundCounts.get(ROUND_COUNT)) {
            return true;
        }
        return false;
    }

    public Race moveAllCarOneTime() {
        for (Car car : raceCars) {
            car.increasePositionOrNot(Util.getRandomNumber());
        }
        roundCounts.put(NOW_ROUND_COUNT, roundCounts.get(NOW_ROUND_COUNT) + 1);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Race race = (Race) o;
        return Objects.equals(raceCars, race.raceCars) &&
                Objects.equals(roundCounts, race.roundCounts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(raceCars, roundCounts);
    }
}
