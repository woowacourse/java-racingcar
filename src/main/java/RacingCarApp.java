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

        OutputView.printStartUI();
        for (int i = 0; i < tryNumber; i++) {
            racingGame.tryMove(cars);
            OutputView.printPosition(cars);
        }

        OutputView.printWinnerName(cars);
    }

}
