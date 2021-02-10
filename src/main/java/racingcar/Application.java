package racingcar;


import java.util.List;
import racingcar.view.input.InputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        List<String> carNames = inputView.getCarNames();
        int racingTryTime = inputView.getRacingTryTime();

        RacingGame racingGame = new RacingGame(carNames, racingTryTime);
        doRace(racingGame);
    }

    private static void doRace(RacingGame racingGame) {
        while(!racingGame.isEnd()) {
            racingGame.race();
            ResultView.printCars(racingGame.getCars());
        }
        ResultView.printWinners(racingGame.getWinners());
    }
}
