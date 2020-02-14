package racingCar;

import racingCar.domain.GameManager;
import racingCar.view.InputView;
import racingCar.view.OutputView;

import java.util.stream.IntStream;

public class Application {
    public static void main(String[] args) throws Exception {

        String namesInput;
        int roundInput;
        GameManager gameManager;
        gameManager = createGameManager();

        roundInput = InputView.InputNumberOfRound();
        OutputView.printTitle();

        IntStream.rangeClosed(1, roundInput)
                .forEach((t) -> {
                    OutputView.printRound(t);
                    gameManager.play();
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
