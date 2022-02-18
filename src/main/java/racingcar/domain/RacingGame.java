package racingcar.domain;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import racingcar.utils.CarsGenerator;
import racingcar.utils.RandomIntegerGenerator;

public class RacingGame {
    private static final int MIN_POSITION = 0;
    private static final int START_RANDOM_NUMBER = 0;
    private static final int END_RANDOM_NUMBER = 9;
    private static final int PROCEED_FlAG_NUMBER = 4;
    private final List<Car> cars;
    private final Integer round;

    public RacingGame(List<String> carNames, Integer round) {
        this.cars = CarsGenerator.generateCars(carNames);
        this.round = round;
    }

    public Map<Integer, List<Car>> race() {
        Map<Integer, List<Car>> raceResults = new LinkedHashMap<>();
        for (int i = 0; i < round; i++) {
            cars.forEach(this::randomDrawAndProceed);
            raceResults.put(i, deepCopyCars());
        }
        return raceResults;
    }

    public List<Car> findWinners() {
        int maxPosition = findMaxPosition();
        return cars.stream()
                .filter(car -> car.isHere(maxPosition))
                .collect(Collectors.toList());
    }

    private List<Car> deepCopyCars() {
        List<Car> copiedCars = new ArrayList<>();
        cars.forEach(car -> copiedCars.add(new Car(car.getName(), car.getPosition())));
        return copiedCars;
    }

    private void randomDrawAndProceed(Car car) {
        if (RandomIntegerGenerator.random(START_RANDOM_NUMBER, END_RANDOM_NUMBER) > PROCEED_FlAG_NUMBER) {
            car.proceed();
        }
    }

    private int findMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(MIN_POSITION);
    }
}
