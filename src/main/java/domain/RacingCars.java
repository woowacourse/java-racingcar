package domain;

import exception.CannotFindMaxPositionException;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class RacingCars {

    private final List<RacingCar> racingCars;

    public RacingCars(final List<RacingCar> racingCars) {
        this.racingCars = new ArrayList<>(racingCars);
    }

    public void moveAll() {
        for (RacingCar racingCar : this.racingCars) {
            racingCar.move();
        }
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }

    public List<String> getWinnerNames() {
        int maxPosition = findMaxPosition(this);

        return racingCars.stream()
                .filter(racingCar -> racingCar.getPosition() == maxPosition)
                .map(RacingCar::getName)
                .collect(toList());
    }

    private int findMaxPosition(final RacingCars racingCars) {
        return racingCars.getRacingCars().stream()
                .mapToInt(RacingCar::getPosition)
                .max()
                .orElseThrow(CannotFindMaxPositionException::new);
    }
}
