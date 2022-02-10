package racingcar;

import racingcar.domain.Car;
import racingcar.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class GameManager {

    List<Car> cars = new ArrayList<>();

    public void run() {
        String[] carNames = requestAndSplitCarNames();
        initCars(carNames);
    }

    private String[] requestAndSplitCarNames() {
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
}
