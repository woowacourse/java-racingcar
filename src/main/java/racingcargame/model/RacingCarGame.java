package racingcargame.model;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {
    public static final int GAME_OVER = 0;

    private CarRepository carRepository;

    public RacingCarGame(List<String> carNames, int raceCount) {
        orderToSaveCars(carNames);
        orderToSaveRaceCount(raceCount);
    }

    private void orderToSaveCars(List<String> carNames) {
        carRepository = new CarRepository(carNames);
    }

    private void orderToSaveRaceCount(int raceCount) {
        RaceCount.storeCount(raceCount);
    }

    public void orderToReduceRaceCount() {
        RaceCount.reduceRaceCount();
    }

    public boolean isOverRace() {
        return RaceCount.getCount() == GAME_OVER;
    }

    public List<CarVO> startRace() {
        orderToReduceRaceCount();
        carRepository.moveCars();

        List<CarVO> cars = new ArrayList<>();
        for (Car car : carRepository.getCars()) {
            cars.add(new CarVO(car.getName(), car.getPosition()));
        }
        return cars;
    }

    public List<String> findRacingGameWinner() {
        return carRepository.findWinner();
    }
}
