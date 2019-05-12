package racingcar;

import racingcar.domain.Car;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingResult;
import racingcar.view.InputView;

import java.util.List;

public class RacingCarController {
    public static void main(String[] args) {
        String userInput = InputView.getUserCarNames();
        int numOfGame = InputView.getNumberOfGame();

        RacingCar racingCar = new RacingCar();
        List<Car> cars = racingCar.process(userInput, numOfGame);

        RacingResult.process(cars);
    }
}
