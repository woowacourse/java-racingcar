import domain.GameProgressService;
import domain.GameResult;
import domain.RandomNumberStrategy;
import domain.WinnerCars;
import view.InputView;
import view.OutputView;

public class Application {
    private static GameProgressService gameProgressService;

    public static void main(String[] args) {
        run();
    }

    private static void run() {
        GameResult gameResult = initGame();

        race(gameResult, InputView.inputRound());
        completeGame(gameResult);
    }

    private static GameResult initGame() {
        gameProgressService = new GameProgressService(new RandomNumberStrategy());
        return gameProgressService.initGameResult(InputView.inputNames());
    }

    private static void race(GameResult gameResult, int gameRound) {
        System.out.println("실행 결과");

        for (int i = 1; i <= gameRound; i++) {
            gameResult = gameProgressService.raceByRound(gameResult);
            OutputView.printPosition(gameResult);
            System.out.println();
        }
    }

    private static void completeGame(GameResult gameResult) {
        WinnerCars winnerCars = new WinnerCars(gameResult.getWinners());
        OutputView.printWinners(winnerCars);
    }
}
