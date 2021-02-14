package car;

import java.util.ArrayList;
import java.util.List;
import view.InputView;
import view.OutputView;

public class GameController {

    private OutputView message = new OutputView();
    private InputView inputView = new InputView();

    public void start() {
        int round = 0;
        List<Car> carNames = new ArrayList<>();
        try {
            carNames = inputView.getCarNames();
            round = inputView.getRound();
            moveCar(carNames, round);
        } catch (IllegalArgumentException error) {
            message.errorPrint();
            start();
        }
    }

    private void moveCar(List<Car> carNames, int round) {
        message.roundStart();
        for (int i = 0; i < round; i++) {
            carNames.forEach(Car::moveOrStop);
            message.printResult(carNames);
        }
        printWinner(carNames);
    }

    private void printWinner(List<Car> carNames) {
        message.printWinners(carNames);
    }

}
