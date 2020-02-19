package racingcargame.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {
    private List<Car> winner = new ArrayList<>();

    public List<EachRaceResultDto> run(String userInputName, int userInputRepeat) {
        final RacingCars cars = new RacingCars(userInputName);
        List<EachRaceResultDto> carStatus = processGame(userInputRepeat, cars);
        winner = cars.getWinners();
        return carStatus;
    }

    private List<EachRaceResultDto> processGame(int repeat, RacingCars cars) {
        List<EachRaceResultDto> carStatus = new ArrayList<>();
        for (int i = 0; i < repeat; i++) {
            carStatus.add(cars.processOneRace());
        }
        return carStatus;
    }

    public List<Car> getWinner() {
        return winner;
    }

}
