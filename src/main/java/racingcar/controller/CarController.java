package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Cars;
import racingcar.domain.TryNumber;
import racingcar.domain.car.Car;
import racingcar.view.OutputView;

public class CarController {

    private static final String Separator = ",";
    private static final String ERROR_MESSAGE = "자동차 이름은 없을 수 없습니다.";
    private static final int ZERO = 0;

    private Cars cars;
    private TryNumber tryNumber;

    public CarController(final String values, final int tryNumber) {
        getCarNames(values);
        this.tryNumber = new TryNumber(tryNumber);
        init();
    }

    private void init() {
        OutputView.printNextLine();
        OutputView.printExecutionResultMessage();
    }

    private void getCarNames(final String values) {
        final List<Car> carList = new ArrayList<>();
        final String[] carNamesArray = carNamesSplit(values);
        for (String carName : carNamesArray) {
            carList.add(new Car(carName));
        }
        cars = new Cars(carList);
    }

    private String[] carNamesSplit(final String carNames) {
        final String[] carNamesArray = carNames.split(Separator);
        if (carNamesArray.length == ZERO) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
        return carNamesArray;
    }

    public void play() {
        cars.move();
        tryNumber = tryNumber.decreaseNumber();
    }

    public boolean isEnd() {
        return tryNumber.isEnd();
    }

    public List<Car> getCars() {
        return cars.getCars();
    }

    public List<Car> getWinners() {
        return cars.getWinners();
    }
}