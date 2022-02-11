package racingcar;

import racingcar.domain.GameManager;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {

    public static void main(String[] args) {
        OutputView.printCarNamesInputRequestMessage();
        String carNamesInput = InputView.requestUserInput();
        OutputView.printTotalRoundsInputRequestMessage();
        String totalRoundsInput = InputView.requestUserInput();

        GameManager gameManager = new GameManager(carNamesInput, totalRoundsInput);
        gameManager.run();
    }
}
