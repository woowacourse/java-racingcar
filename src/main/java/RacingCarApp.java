import domain.Car;
import domain.RacingGame;
import view.InputView;
import view.OutputView;

import java.util.List;

public class RacingCarApp {

    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame();

        List<Car> cars = InputView.createCars();
        int tryNumber = InputView.inputTryNum();

        racingGame.startRacing(cars, tryNumber);

        OutputView.printWinnerName(cars);
    }

}
