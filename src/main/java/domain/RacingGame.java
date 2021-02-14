package domain;

import car.Car;
import java.util.List;
import view.OutputView;

public class RacingGame {

    private final List<Car> carNames;
    private final int round;
    private OutputView message = new OutputView();

    public RacingGame(List<Car> carNames, int round) {
        this.carNames = carNames;
        this.round = round;
    }

    public void moveCar(List<Car> carNames, int round) {

        message.roundStart();
        for (int i = 0; i < round; i++) {
            carNames.forEach(Car::moveOrStop);
            message.printResult(carNames);
        }
        printWinner(carNames);
    }
}
