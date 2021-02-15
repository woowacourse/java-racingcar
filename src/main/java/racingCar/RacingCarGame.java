package racingCar;

import view.OutputView;

public class RacingCarGame {
    private Cars cars;

    public RacingCarGame(Cars cars) {
        this.cars = cars;
    }

    public void run(){
        cars.moveCar();
    }
}
