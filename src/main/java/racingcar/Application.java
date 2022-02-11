package racingcar;

import racingcar.domain.GameManager;
import racingcar.view.InputView;

import static racingcar.util.ValidatorUtils.splitAndValidateCarNames;
import static racingcar.util.ValidatorUtils.validateAndParsePositiveInt;

public class Application {

    public static void main(String[] args) {
        String carNamesInput = InputView.requestCarNameInput();
        String[] carNames = splitAndValidateCarNames(carNamesInput);

        String totalRoundsInput = InputView.requestTotalRoundsInput();
        int totalRounds = validateAndParsePositiveInt(totalRoundsInput);

        GameManager gameManager = new GameManager(carNames, totalRounds);
        gameManager.run();
    }
}
