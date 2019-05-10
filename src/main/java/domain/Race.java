package domain;

import util.Util;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private List<Car> raceCars;
    private int roundCount;
    private int maxPosition = Const.ZERO;

    public Race(List<Car> raceCars, int roundCount) {
        this.raceCars = raceCars;
        this.roundCount = roundCount;
    }

    public void moveAllCarOneTime() {
        for (Car car : raceCars) {
            car.increasePositionOrNot(Util.getRandomNumber());
            if (car.isGreaterThanMaxPosition(maxPosition)) {
                ++this.maxPosition;
            }
        }
    }

    public List<Car> getRaceCars() {
        return raceCars;
    }

    public String getRaceWinners() {
        List<String> winnersList = new ArrayList<>();

        raceCars.stream().filter(x -> x.matchPosition(maxPosition))
                .forEach(x -> winnersList.add(x.getName()));

        return String.join(",", winnersList);
    }
}
