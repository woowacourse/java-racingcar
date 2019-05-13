package domain;

import java.util.*;

public class Winners {
    private List<CarDto> carsFinishedRace;

    public Winners(List<CarDto> carsFinishedRace) {
        this.carsFinishedRace = carsFinishedRace;
    }

    public String getRaceWinners() {
        List<String> winners = new ArrayList<>();
        int maxPosition = getMaxPosition();

        carsFinishedRace.stream().filter(x -> x.isMaxPosition(maxPosition))
                .forEach(x -> winners.add(x.getName()));

        return String.join(",", winners);
    }

    private int getMaxPosition() {
        return carsFinishedRace
                .stream()
                .max(Comparator.comparing(CarDto::getPosition))
                .orElseThrow(NoSuchElementException::new).getPosition();
    }
}
