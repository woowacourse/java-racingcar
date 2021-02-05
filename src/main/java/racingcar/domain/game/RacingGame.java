package racingcar.domain.game;

import racingcar.domain.car.CarStates;
import racingcar.domain.car.CarStatesBuffer;
import racingcar.domain.car.Cars;

public class RacingGame {
    private Cars cars;
    private int moveCount;

    private CarStatesBuffer carStatesBuffer;

    public RacingGame(Cars cars, int moveCount) {
        this.cars = cars;
        this.moveCount = moveCount;
        this.carStatesBuffer = new CarStatesBuffer();
    }

    public GameResult start() {
        moveUntilMoveCount();
        clearCarStateBuffer();

        return GameResult.valueOf(
                cars.getWinners(),
                carStatesBuffer
        );
    }

    private void clearCarStateBuffer() {
        carStatesBuffer.clear();
    }

    private void moveUntilMoveCount() {
        for (int i = 0; i < moveCount; i++) {
            cars.move();
            CarStates carStates = cars.getCarStates();
            carStatesBuffer.append(carStates);
        }
    }
}
