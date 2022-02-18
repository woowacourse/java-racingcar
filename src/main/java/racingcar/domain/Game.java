package racingcar.domain;

import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.domain.numbergenerator.NumberGenerator;
import racingcar.dto.CarDto;

import java.util.List;

public class Game {
    private static final String NEGATIVE_ERROR_MESSAGE = "[ERROR] 음수를 입력할 수 없습니다";
    private static final int ERROR_CRITERIA_VALUE_ZERO = 0;

    private final Cars cars;
    private final int gameCount;

    public Game(List<Car> cars, int gameCount) {
        this.cars = new Cars(cars);
        validateGameCount(gameCount);
        this.gameCount = gameCount;
    }

    public Cars play(NumberGenerator numberGenerator) {
        for (Car car : cars.getCars()) {
            car.move(numberGenerator);
        }
        return cars;
    }

    public List<Car> judgeWinner() {
        return cars.getSamePositionCar(cars.getMaxPosition());
    }

    private void validateGameCount(int gameCount) {
        if (gameCount < ERROR_CRITERIA_VALUE_ZERO) {
            throw new IllegalArgumentException(NEGATIVE_ERROR_MESSAGE);
        }
    }

    public List<CarDto> getCarDto() {
        return cars.toCarDto();
    }

    public int getGameCount() {
        return gameCount;
    }
}
