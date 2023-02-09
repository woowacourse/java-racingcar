package domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<String> getWinnerNames(){
        List<RacingCar> racingCars = getSortedByPosition(this);
        int winnerPosition = racingCars.get(0).getPosition();

        return racingCars.stream()
                .filter(racingCar -> racingCar.getPosition() == winnerPosition)
                .map(RacingCar::getName)
                .collect(Collectors.toList());
    }

    private List<RacingCar> getSortedByPosition(final RacingCars racingCars){
        return racingCars.getRacingCars()
                .stream()
                .sorted(Comparator.comparing(RacingCar::getPosition).reversed())
                .collect(Collectors.toList());
    }
}
