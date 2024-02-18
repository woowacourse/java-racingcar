package domain;

import java.util.List;

public class Winners {

    private List<String> winners;

    private Winners(List<String> winners) {
        this.winners = winners;
    }

    public static Winners findWinners(Cars cars) {
        List<String> winners = cars.getCars().stream()
                .filter(car -> car.getForward() == cars.getMaxForward())
                .map(Car::getName)
                .toList();

        return new Winners(winners);
    }

    public List<String> getWinners() {
        return winners;
    }
}
