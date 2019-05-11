package domain;

import util.Util;

import java.util.ArrayList;
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

    public Race(List<Car> raceCars) {
        this.raceCars = raceCars;
        this.maxPosition = Const.RACE_OBJ_INIT_MAX_POSITION;
    }

    public List<Car> getRaceCars() {
        return raceCars;
    }

    public String getRaceWinners() {
        List<String> winners = new ArrayList<>();

        raceCars.stream().filter(x -> x.isMaxPosition(maxPosition))
                .forEach(x -> winners.add(x.toString().split(" ")[0]));

        return String.join(",", winners);
    }

    public void moveAllCarOneTime() {
        for (Car car : raceCars) {
            car.increasePositionOrNot(Util.getRandomNumber());
            if (car.checkGreaterThanMaxPos(maxPosition)) {
                ++this.maxPosition;
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Race race = (Race) o;
        return maxPosition == race.maxPosition &&
                Objects.equals(raceCars, race.raceCars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(raceCars, maxPosition);
    }
}
