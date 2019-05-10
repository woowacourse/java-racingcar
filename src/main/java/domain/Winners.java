package domain;

import java.util.ArrayList;
import java.util.List;

public class Winners {
    private List<Car> carsFinishedRace;

    public Winners(List<Car> carsFinishedRace) {
        this.carsFinishedRace = carsFinishedRace;
    }

    public int getMaxPosition() {
        int maxPosition = 0;

        for (Car car : carsFinishedRace) {
            if (car.isGreaterThanMaxPosition(maxPosition)) {
                maxPosition += car.getPositionGap(maxPosition);
            }
        }
        return maxPosition;
    }

    public String getRaceWinners(int maxPosition) {
        List<String> winners = new ArrayList<>();

        carsFinishedRace.stream().filter(x -> x.matchPosition(maxPosition))
                .forEach(x -> winners.add(x.getName()));

        return String.join(",", winners);
    }
}
