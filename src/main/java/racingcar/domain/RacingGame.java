package racingcar.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class RacingGame {
    private final Cars cars;
    private final Integer round;

    public RacingGame(List<String> carNames, Integer round) {
        this.cars = new Cars(carNames);
        this.round = round;
    }

    public Map<Integer, List<CarDto>> race() {
        Map<Integer, List<CarDto>> raceResults = new LinkedHashMap<>();
        for (int i = 0; i < round; i++) {
            cars.proceedAll();
            raceResults.put(i, cars.toCarDtos());
        }
        return raceResults;
    }

    public List<Car> findWinners() {
        int maxPosition = cars.findMaxPosition();
        return cars.getCarsHere(maxPosition);
    }
}
