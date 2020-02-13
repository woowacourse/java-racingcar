package racingcar.domain;

import racingcar.view.InputView;

public class Game { //게임 로직 구현

    public void run() {
        InputView.getNames();
        InputView.getTrial();
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
