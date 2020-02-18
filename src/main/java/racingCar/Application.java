package racingCar;

import racingCar.domain.GameManager;
import racingCar.view.InputView;
import racingCar.view.OutputView;

import java.util.stream.IntStream;

public class Application {
    public static void main(String[] args) throws Exception {
        GameManager gameManager = createGameManager();
        int roundInput = InputView.InputNumberOfRound();
        OutputView.printTitle();

        IntStream.rangeClosed(1, roundInput)
                .forEach((t) -> {
                    OutputView.printRound(t);
                    gameManager.playersPlay();
                    OutputView.printEachRound(gameManager.toString());
                });
        OutputView.printWinners(gameManager.getWinners());
    }

    private static GameManager createGameManager() {
        String namesInput = InputView.InputUserNames();
        GameManager gameManager = new GameManager(namesInput);

        while (!gameManager.isCreated()) {
            OutputView.printInvalidInputCheck();
            namesInput = InputView.InputUserNames();
            gameManager = new GameManager(namesInput);
        }
        return gameManager;
    }
}
