package racingcar.domain;

import racingcar.domain.dto.WinnerDto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {

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

    public WinnerDto getWinners() {
        ArrayList<RacingCar> winnersCandidate = getWinnersCandidate();
        ArrayList<String> winnersName = new ArrayList<>();
        for (RacingCar winner : winnersCandidate) {
            winnersName.add(winner.getName());
        }
        return new WinnerDto(winnersName);
    }

    private ArrayList<RacingCar> getWinnersCandidate() {
        RacingCar racingCarOfMaxPosition = getRacingCarWithMaxPosition();

        return racingCars.stream()
                .filter(racingCar -> racingCar.isSamePosition(racingCarOfMaxPosition))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private RacingCar getRacingCarWithMaxPosition() {
        return racingCars.stream().max(Comparator.comparingInt(RacingCar::getPosition)).get();
    }
}
