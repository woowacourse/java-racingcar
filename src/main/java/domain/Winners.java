package domain;

import java.util.*;

public class Winners {
    private List<Car> carsFinishedRace;

    public Winners(List<Car> carsFinishedRace) {
        this.carsFinishedRace = carsFinishedRace;
    }

    private int getMaxPosition() {
        return carsFinishedRace
                .stream()
                .max(Comparator.comparing(Car::getPosition))
                .orElseThrow(NoSuchElementException::new).getPosition();
    }

    public String getRaceWinners() {
        List<String> winners = new ArrayList<>();
        int maxPosition = getMaxPosition();

        carsFinishedRace.stream().filter(x -> x.matchPosition(maxPosition))
                .forEach(x -> winners.add(x.getName()));

        return String.join(",", winners);
    }
}
