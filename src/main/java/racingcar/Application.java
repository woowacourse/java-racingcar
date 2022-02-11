package racingcar;

import racingcar.domain.GameManager;
import racingcar.view.InputView;

public class Application {

    public static void main(String[] args) {
        String carNamesInput = InputView.requestCarNameInput();
        String totalRoundsInput = InputView.requestTotalRoundsInput();

        GameManager gameManager = new GameManager(carNamesInput, totalRoundsInput);
        gameManager.run();
    }
}
