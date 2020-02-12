package racingcar.domain;

import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Game { //게임 로직 구현

    public void run() {
        InputView inputView = new InputView();
        String[] carNames = inputView.getCarNames();
        int attempts = inputView.getGameCounts();
        Cars cars = createCars(carNames);
        for (int i = 0 ; i < attempts ; i++) {
            cars.moveCars();
            OutputView.printCurrentResult(cars.getCurrentResult());
        }

    }

    private Cars createCars(String[] carNames) {
        List<Car> carList = new ArrayList<Car>();
        for (String carName : carNames) {
            carList.add(new Car(carName));
        }

        Cars cars = new Cars(carList);
        return cars;
    }
}
