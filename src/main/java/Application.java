import domain.GameResult;
import domain.WinnerCars;
import view.InputView;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        run();
    }

    private static void run() {
        GameResult.registerCarNameAndGameRound(InputView.inputNames(), InputView.inputRound());
        race();
        WinnerCars.determineWinners(GameResult.getCars());
        OutputView.printWinners(WinnerCars.getWinnerCars());
    }

    private static void race() {
        System.out.println("실행 결과");

        for (int i = 1; i <= GameResult.getGameRound(); i++) {
            GameResult.raceByRound();
            OutputView.printPosition(GameResult.getCars());
            System.out.println();
        }
    }
}
