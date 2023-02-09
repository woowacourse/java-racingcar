package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarService {
    private Cars cars = new Cars(new ArrayList<Car>());
    private int tryCount;

    public void initializeService() {
        while (validateNameInput()) {
            cars = new Cars(new ArrayList<Car>());
        }
        while (validateCountInput()) {
        }
    }

    public void runService() {
        OutputView.printResultMessage();
    }

    private boolean validateNameInput() {
        try {
            OutputView.printNameInput();
            List<String> carNames = splitCarNames(InputView.readCarNames());
            makeCar(carNames);
            return false;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return true;
        }
    }

    private void makeCar(List<String> carNames) {
        for (String carName : carNames) {
            Car car = new Car(carName, 0);
            cars.addCarInformation(car);
        }
    }

    private List<String> splitCarNames(String carNames) {
        return List.of(carNames.split(","));
    }

    private boolean validateCountInput() {
        try {
            OutputView.printCountInput();
            tryCount = InputView.readTryCount();
            validateNegativeCount(tryCount);
            return false;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return true;
        }
    }

    private void validateNegativeCount(int tryCount) {
        if (tryCount <= 0) {
            throw new IllegalArgumentException("[ERROR] 시도할 횟수는 0보다 큰 숫자여야 합니다.");
        }
    }
}
