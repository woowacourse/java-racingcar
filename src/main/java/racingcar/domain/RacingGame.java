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

    public Map<Integer, List<CarDto>> race() {
        Map<Integer, List<CarDto>> raceResults = new LinkedHashMap<>();
        for (int i = 0; i < round; i++) {
            cars.forEach(this::proceedOrStopCar);
            raceResults.put(i, toCarDtos());
        }
        return raceResults;
    }

    public List<Car> findWinners() {
        int maxPosition = findMaxPosition();
        return cars.stream()
                .filter(car -> car.isHere(maxPosition))
                .collect(Collectors.toList());
    }

    private List<CarDto> toCarDtos() {
        return cars.stream()
                .map(Car::toDto)
                .collect(Collectors.toList());
    }

    private void proceedOrStopCar(Car car) {
        if (carProceedCondition()) {
            car.proceed();
        }
    }

    private boolean carProceedCondition() {
        return RandomIntegerGenerator.random(START_RANDOM_NUMBER, END_RANDOM_NUMBER) > PROCEED_FlAG_NUMBER;
    }

    private int findMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(MIN_POSITION);
    }
}
