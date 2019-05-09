package domain;

import util.Util;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private List<Car> raceCars;
    private int maxPosition = Const.ZERO;

    public Race(List<Car> raceCars) {
        this.raceCars = raceCars;
    }

    public void moveAllCarOneTime() {
        for (Car car : raceCars) {
            car.increasePositionOrNot(Util.getRandomNumber());
            if (car.checkGreaterThanMaxPos(maxPosition)) {
                ++this.maxPosition;
            }
        }
    }

    public List<Car> getRaceCars() {
        return raceCars;
    }

    public String getRaceWinners() {
        List<String> winnersList = new ArrayList<>();

        raceCars.stream().filter(x -> x.isMaxPosition(maxPosition))
                .forEach(x -> winnersList.add(x.getName()));

        return String.join(",", winnersList);
    }
}
