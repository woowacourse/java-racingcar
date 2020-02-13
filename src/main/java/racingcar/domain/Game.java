package racingcar.domain;

import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class Game { //게임 로직 구현

//    private Winners winners = new Winners();
    public void run() {
        Cars cars = new Cars();
        InputView.getNames();
//        cars = createCars(carNames);
//        for (int i = 0 ; i < trial ; i++) {
//            cars.moveCars();
//            OutputView.printCurrentResult(cars.getCurrentResult());
//        }
//        Winners.selectWinners(cars.getCars());
//        OutputView.printWinnerResult();
    }

    private Cars createCars(String[] carNames) {
        Cars cars = new Cars();
        for (String carName : carNames) {
            cars.addCar(new Car(carName));
        }
        return cars;
    }
}
