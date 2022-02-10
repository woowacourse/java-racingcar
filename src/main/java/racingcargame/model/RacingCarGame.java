package racingcargame.model;

import java.util.List;
import java.util.Random;

public class RacingCarGame {
    private CarRepository carRepository;

    public RacingCarGame() {
    }

    public void orderToSaveCars(List<String> carNames) {
        carRepository = new CarRepository(carNames);
    }

    public void orderToSaveRaceCount(int raceCount) {
        RaceCount.storeCount(raceCount);
    }

    public boolean isOverRace(){
        return RaceCount.getCount() == 0;
    }

    public void startRace() {
        RaceCount.reduceRaceCount();
        carRepository.moveCars();
    }
}
