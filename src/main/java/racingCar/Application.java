package racingCar;

import racingCar.domain.GameManager;
import racingCar.view.InputView;
import racingCar.view.OutputView;

import java.util.stream.IntStream;

public class Application {
    public static void main(String[] args) throws Exception {

        String namesInput = InputView.InputUserNames();
        int roundInput = InputView.InputNumberOfRound();
        GameManager gameManager = new GameManager(namesInput);
        OutputView.printTitle();
        IntStream.rangeClosed(1, roundInput)
                .forEach((t) -> {
                    OutputView.printRound(t);
                    gameManager.play();
                    OutputView.printEachRound(gameManager.toString());
                });
        OutputView.printWinners(gameManager.getWinners());
    }


}
