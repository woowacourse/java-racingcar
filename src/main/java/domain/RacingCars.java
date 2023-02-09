package domain;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {

    private final List<RacingCar> racingCars = new ArrayList<>();

    public RacingCars(final List<RacingCar> racingCars) {
        this.racingCars.addAll(racingCars);
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
        List<RacingCar> racingCars = getSortedByPosition(this);
        int winnerPosition = racingCars.get(0).getPosition();

        return racingCars.stream()
                .filter(racingCar -> racingCar.getPosition() == winnerPosition)
                .map(RacingCar::getName)
                .collect(toList());
    }

    private List<RacingCar> getSortedByPosition(final RacingCars racingCars) {
        return racingCars.getRacingCars()
                .stream()
                .sorted(comparing(RacingCar::getPosition).reversed())
                .collect(toList());
    }
}
