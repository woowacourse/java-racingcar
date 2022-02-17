package racingcargame.model;

import java.util.List;
import racingcargame.dto.CarDto;
import racingcargame.utils.RandomNumberGenerator;

public class RacingCarGame {
    private final Cars cars;
    private final RaceCount raceCount;

    public RacingCarGame(final List<String> racingCarNames, final String raceCount) {
        this.cars = new Cars(racingCarNames);
        this.raceCount = new RaceCount(raceCount);
    }

    public boolean isNotOverRace() {
        return raceCount.hasCount();
    }

    public void startRace(final RandomNumberGenerator randomNumberGenerator) {
        raceCount.reduceCount();
        cars.moveCars(randomNumberGenerator);
    }

    public List<CarDto> sendRacingCarsInformation() {
        return cars.bringCarsInformation();
    }

    public List<CarDto> sendRacingGameWinner() {
        return cars.findWinner();
    }
}
