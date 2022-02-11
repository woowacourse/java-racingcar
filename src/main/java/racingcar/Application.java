package racingcar;

import racingcar.domain.GameManager;
import racingcar.view.InputView;

import static racingcar.util.ValidatorUtils.validateAndParsePositiveInt;

public class Application {

    public static void main(String[] args) {
        String carNamesInput = InputView.requestCarNameInput();
        String totalRoundsInput = InputView.requestTotalRoundsInput();
        int totalRounds = validateAndParsePositiveInt(totalRoundsInput);

        GameManager gameManager = new GameManager(carNamesInput, totalRounds);
        gameManager.run();
    }
}
