import domain.*;
import view.InputView;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        Cars cars = createCarsByInput();
        AttemptNumber attemptNumber = createAttemptNumberByInput();

        GameManager gameManager = new GameManager(cars, attemptNumber);
        gameManager.playGame();

        int maxPosition = cars.getMaxPosition();
        Cars winners = new Cars(cars.findByPosition(maxPosition));
        OutputView.printWinners(winners);
    }

    private static Cars createCarsByInput() {
        while(true) {
            try {
                String carNames = InputView.inputCarNames();
                return new Cars(CarGenerator.create(carNames));
            } catch (IllegalArgumentException e) {
                OutputView.printExceptionMsg(e.getMessage());
            }
        }
    }

    private static AttemptNumber createAttemptNumberByInput() {
        while(true) {
            try {
                return new AttemptNumber(InputView.inputAttemptNumber());
            } catch (IllegalArgumentException e) {
                OutputView.printExceptionMsg(e.getMessage());
            }
        }
    }

}
