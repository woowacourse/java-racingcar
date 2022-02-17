package racingcargame.model;

import java.util.List;
import racingcargame.dto.CarDto;

public class RacingCarGame {
    private static final int GAME_OVER_COUNT = 0;

    private Cars cars;
    private RaceCount raceCount;

    public RacingCarGame(List<String> racingCarNames, String raceCount) {
        prepareRacingCars(racingCarNames);
        prepareRaceCount(raceCount);
    }

    private void prepareRacingCars(final List<String> racingCarNames) {
        cars = new Cars(racingCarNames);
    }

    private void prepareRaceCount(final String raceCount) {
        this.raceCount = new RaceCount(raceCount);
    }

    public boolean isNotOverRace() {
        return raceCount.getCount() == GAME_OVER_COUNT;
    }

    public void startRace() {
        raceCount.reduceCount();
        cars.moveCars();
    }

    public List<CarDto> sendPositionOfRacingCars() {
        return cars.bringCarsInformation();
    }

    public List<CarDto> sendRacingGameWinner() {
        return cars.findWinner();
    }
}
