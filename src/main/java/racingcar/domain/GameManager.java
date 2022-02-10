package racingcar.domain;

import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

import static racingcar.util.ValidatorUtils.validateNoDuplicates;
import static racingcar.util.ValidatorUtils.validateNotBlank;
import static racingcar.util.ValidatorUtils.validateNotOverFiveCharacters;
import static racingcar.util.ValidatorUtils.validatePositiveInt;

public class GameManager {

    List<Car> cars = new ArrayList<>();
    int totalRounds;

    public void run() {
        String[] carNames = requestAndSplitCarNames();
        initCars(carNames);
        totalRounds = requestAndParseTotalRounds();
    }

    private String[] requestAndSplitCarNames() {
        OutputView.printCarNamesInputRequestMessage();
        String userInput = InputView.requestUserInput();
        return getValidateCarNames(userInput);
    }

    private String[] getValidateCarNames(String userInput) {
        String[] carNames = splitUserInputByComma(userInput);

        for (String name : carNames) {
            validateNotBlank(name);
            validateNotOverFiveCharacters(name);
        }
        validateNoDuplicates(carNames);

        return carNames;
    }

    private String[] splitUserInputByComma(String userInput) {
        return userInput.split(",");
    }

    private void initCars(String[] carNames) {
        for (String name : carNames) {
            cars.add(new Car(name));
        }
    }

    private int requestAndParseTotalRounds() {
        OutputView.printTotalRoundsInputRequestMessage();
        String userInput = InputView.requestUserInput();
        return getValidateTotalRounds(userInput);
    }

    private int getValidateTotalRounds(String userInput) {
        int totalRoundsInput = Integer.parseInt(userInput);
        validatePositiveInt(totalRoundsInput);
        return totalRoundsInput;
    }
}
