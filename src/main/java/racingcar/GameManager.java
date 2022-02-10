package racingcar;

import racingcar.domain.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

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
        return splitUserInputByComma(userInput);
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
