package racingcar.controller;

import racingcar.domain.car.Car;
import racingcar.domain.car.CarFactory;
import racingcar.domain.car.Cars;
import racingcar.domain.numbergenerator.NumberGenerator;
import racingcar.dto.CarsDto;
import racingcar.dto.WinnerCarsDto;

import java.util.List;

public class GameController {
    private static final String NEGATIVE_ERROR_MESSAGE = "[ERROR] 음수를 입력할 수 없습니다";
    private static final int ERROR_CRITERIA_VALUE_ZERO = 0;

    private Cars cars;

    public void createCars(String carNames) {
        cars = new Cars(CarFactory.from(carNames));
    }

    public int createGameCount(int gameCount) {
        return validateGameCount(gameCount);
    }

    private int validateGameCount(int gameCount) {
        if (gameCount < ERROR_CRITERIA_VALUE_ZERO) {
            throw new IllegalArgumentException(NEGATIVE_ERROR_MESSAGE);
        }
        return gameCount;
    }

    public CarsDto move(NumberGenerator numberGenerator) {
        return cars.move(numberGenerator);
    }

    public WinnerCarsDto judgeWinner() {
        int maxPosition = cars.getMaxPosition();
        List<Car> winnerCars = cars.getSamePositionCar(maxPosition);
        return WinnerCarsDto.from(winnerCars);
    }

}
