package racingcar;

import racingcar.view.InputView;

public class GameManager {

    public void run() {
        String[] carNames = requestAndSplitCarNames();
    }

    private String[] requestAndSplitCarNames() {
        String userInput = InputView.requestUserInput();
        return splitUserInputByComma(userInput);
    }

    private String[] splitUserInputByComma(String userInput) {
        return userInput.split(",");
    }
}
