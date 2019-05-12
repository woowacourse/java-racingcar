import domain.GameResult;
import domain.WinnerCars;
import view.InputView;
import view.OutputView;

public class Application {
    private static GameResult gameResult;

    public static void main(String[] args) {
        run();
    }

    private static void run() {
        gameResult = new GameResult(InputView.inputNames(), InputView.inputRound());
        WinnerCars winnerCars = new WinnerCars();

        race();
        winnerCars.determineWinners(gameResult);
        OutputView.printWinners(winnerCars);
    }

    private static void race() {
        System.out.println("실행 결과");

        for (int i = 1; i <= gameResult.getGameRound(); i++) {
            gameResult.raceByRound();
            OutputView.printPosition(gameResult);
            System.out.println();
        }
    }
}
