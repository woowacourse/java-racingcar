package domain;

import util.Util;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private List<Car> carsOnRace;
    private int roundCount;
    private int maxPosition = Const.ZERO;

    public Race(List<Car> carsOnRace, int roundCount) {
        this.carsOnRace = carsOnRace;
        this.roundCount = roundCount;
    }

    public String moveAllCarsByRoundCount() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < roundCount; i++) {
            stringBuilder.append(moveAllCarsByOneTime());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    private String moveAllCarsByOneTime() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Car car : carsOnRace) {
            car.increasePositionOrNot(Util.getRandomNumber());
            stringBuilder.append(car.toString());
            if (car.isGreaterThanMaxPosition(maxPosition)) {
                ++this.maxPosition;
            }
        }
        return stringBuilder.toString();
    }

    public List<Car> getRaceCars() {
        return carsOnRace;
    }

    public String getRaceWinners() {
        List<String> winnersList = new ArrayList<>();

        carsOnRace.stream().filter(x -> x.matchPosition(maxPosition))
                .forEach(x -> winnersList.add(x.getName()));

        return String.join(",", winnersList);
    }
}
