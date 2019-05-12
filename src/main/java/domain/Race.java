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
    private int maxPosition;
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

        this.maxPosition = Const.RACE_OBJ_INIT_MAX_POSITION;
        setMaxPosition(this.raceCars);
    }

    private void setMaxPosition(List<Car> cars) {
        for (Car car : cars) {
            setMaxPosition(car);
        }
    }

    private void setMaxPosition(Car car) {
        if (car.checkGreaterThanMaxPos(maxPosition)) {
            ++this.maxPosition;
        }
    }

    public List<String> getRaceCarInfo() {
        List<String> carNames = new ArrayList<>();
        for (Car car : raceCars) {
            carNames.add(car.toString());
        }
        return carNames;
    }

    public String getRaceWinners() {
        List<String> winners = new ArrayList<>();

        raceCars.stream().filter(x -> x.isMaxPosition(maxPosition))
                .forEach(x -> winners.add(x.toString().split(" ")[0]));

        return String.join(",", winners);
    }

    public Race moveAllCars() {
        while (hasNextRound()) {
            moveAllCarOneTime();
        }
        return this;
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
            setMaxPosition(car);
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
