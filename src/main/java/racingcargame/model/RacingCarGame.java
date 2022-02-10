package racingcargame.model;

import java.util.*;

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

    public boolean isOverRace() {
        return RaceCount.getCount() == 0;
    }

    public List<CarVO> startRace() {
        RaceCount.reduceRaceCount();
        carRepository.moveCars();

        List<CarVO> cars = new ArrayList<>();
        for (Car car : carRepository.getCars()) {
            cars.add(new CarVO(car.getName(), car.getPosition()));
        }
        return cars;
    }
}
