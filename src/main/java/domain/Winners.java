package domain;

import java.util.List;

public class Winners {

    private List<String> winners;

    private Winners(List<String> winners) {
        this.winners = winners;
    }

    public static Winners createWinners(Cars cars) {
        List<String> winners = cars.getCars().stream()
                .filter(car -> car.getPosition() == cars.getMaxPosition())
                .map(Car::getName)
                .toList();

        return new Winners(winners);
    }

    public List<String> getWinners() {
        return winners;
    }
}
