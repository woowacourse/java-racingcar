package racingcar.domain;

import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class Game { //게임 로직 구현

    public void run() {
        InputView inputView = new InputView();
        String[] carNames = inputView.getCarNames();
        int trial = inputView.getTrial();
        Cars cars = createCars(carNames);
        for (int i = 0 ; i < trial ; i++) {
            cars.moveCars();
            OutputView.printCurrentResult(cars.getCurrentResult());
        }
        cars.selectWinners();
    }

    private Cars createCars(String[] carNames) {
        Cars cars = new Cars();
        for (String carName : carNames) {
            cars.addCar(new Car(carName));
        }
        return cars;
    }
}
