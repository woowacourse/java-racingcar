import domain.RacingGame;
import view.InputView;
import view.OutputView;

public class RacingCarApp {

    public static void main(String[] args) {
        RacingGame racingGame = createRacingGame();
        int tryNumber = InputView.inputTryNum();

        OutputView.printStartUI();
        for (int i = 0; i < tryNumber; i++) {
            racingGame.tryMove();
            OutputView.printPosition(racingGame.getCars());
        }

        OutputView.printWinnerName(racingGame.getCars());
    }

    private static RacingGame createRacingGame() {
        String inputString = InputView.createCars();
        try {
            return new RacingGame(inputString);
        } catch (IllegalArgumentException e) {
            return createRacingGame();
        }
    }
}
