package racingCar.domain.service;

import java.util.Arrays;
import java.util.List;
import racingCar.domain.CarDto;
import racingCar.domain.Cars;
import racingCar.domain.RoundCount;
import racingCar.domain.utils.Util;

public class RacingGame {
    private final Cars cars;
    private final RoundCount roundCount;

    public RacingGame(String names, String count) {
        this.cars = initCars(names);
        this.roundCount = initRoundCount(count);
    }

    public void go() {
        cars.go();
        roundCount.minusOne();
    }

    public List<String> getWinnerCars() {
        return cars.getSamePositionCarsDto(cars.getMaxPosition());
    }

    private Cars initCars(String nameString) {
        String[] names = Util.separate(nameString);
        return new Cars(Arrays.asList(names));
    }

    private RoundCount initRoundCount(String countInput) {
        int count = Util.convertToInteger(countInput);
        return new RoundCount(count);
    }

    public List<CarDto> getResult() {
        return cars.getDto();
    }

    public RoundCount getRoundCount() {
        return roundCount;
    }
}