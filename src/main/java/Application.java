import domain.*;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        String carNames = InputView.inputCarNames();
        Cars cars = new Cars(CarGenerator.create(carNames));
        AttemptNumber attemptNumber = new AttemptNumber(InputView.inputAttemptNumber());
        GameManager gameManager = new GameManager(cars, attemptNumber);
        gameManager.playGame();
        int maxPosition = cars.getMaxPosition();
        Winners winners = new Winners(cars.findWinners(maxPosition));
        OutputView.printWinners(winners);
    }

}
