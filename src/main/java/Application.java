import domain.GameProgressService;
import domain.GameResult;
import domain.WinnerCars;
import domain.WinnerDecisionService;
import view.InputView;
import view.OutputView;

public class Application {
    private static GameResult gameResult;

    public static void main(String[] args) {
        run();
    }

    private static void run() {
        WinnerCars winnerCars;
        gameResult = new GameResult(InputView.inputNames(), InputView.inputRound());

        race();
        winnerCars = new WinnerCars(WinnerDecisionService.decideWinners(gameResult));

        OutputView.printWinners(winnerCars);
    }

    private static void race() {
        System.out.println("실행 결과");

        for (int i = 1; i <= gameResult.getGameRound(); i++) {
            GameProgressService.raceByRound(gameResult);
            OutputView.printPosition(gameResult);
            System.out.println();
        }
    }
}
