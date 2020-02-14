package racingCar;

import racingCar.domain.Players;
import racingCar.view.InputView;
import racingCar.view.OutputView;

import java.util.stream.IntStream;

public class Application {
    public static void main(String[] args) {
        Players gameManager = createGameManager();
        int roundInput = InputView.InputNumberOfRound();

        OutputView.printTitle();

        IntStream.rangeClosed(1, roundInput)
                .forEach((t) -> {
                    OutputView.printRound(t);
                    gameManager.play();
                    OutputView.printEachRound(gameManager.toString());
                });

        OutputView.printWinners(gameManager.getWinners());
    }

    private static Players createGameManager() {
        String namesInput = InputView.InputUserNames();
        Players gameManager = new Players(namesInput);
        while (gameManager.isEmpty()) {
            OutputView.printInvalidNameWarning();
            namesInput = InputView.InputUserNames();
            gameManager = new Players(namesInput);
        }
        return gameManager;
    }
}
