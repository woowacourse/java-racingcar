package racingcar.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {

    private static final String WINNER_NAME_DELIMITER = ", ";
    private final List<RacingCar> racingCars;

    public RacingCars() {
        racingCars = new ArrayList<>();
    }

    public RacingCars(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    public void join(String[] validCarNames) {
        for (String validCarName : validCarNames) {
            racingCars.add(RacingCar.generateRacingCar(validCarName));
        }
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }


    public String getWinnersName() {
        ArrayList<RacingCar> winners = getWinners();
        ArrayList<String> winnersName = new ArrayList<>();
        for (RacingCar winner : winners) {
            winnersName.add(winner.getName());
        }
        return String.join(WINNER_NAME_DELIMITER, winnersName);
    }

    private ArrayList<RacingCar> getWinners() {

        RacingCar racingCarOfMaxPosition = getRacingCarWithMaxPosition();

        return racingCars.stream()
                .filter(racingCar -> racingCar.isSamePosition(racingCarOfMaxPosition))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private RacingCar getRacingCarWithMaxPosition() {
        return racingCars.stream().max(Comparator.comparingInt(RacingCar::getPosition)).get();
    }
}
