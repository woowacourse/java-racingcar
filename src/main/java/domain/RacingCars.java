package domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {
    private List<Car> cars;

    public RacingCars(List<Car> cars) {
        this.cars = cars;
    }

    public String getWinnerName(List<Car> winners) {
        String[] winnersString = new String[winners.size()];
        for (int i=0; i<winners.size(); i++) {
            winnersString[i] = winners.get(i).getName();
        }
        return String.join(", ", winnersString);
    }

    public List<Car> getWinner() {
        Collections.sort(cars);
        int maxPosition = cars.get(0).getPosition();

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }
}
