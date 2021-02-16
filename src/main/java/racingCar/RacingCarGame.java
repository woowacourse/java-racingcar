package racingCar;

import utils.RandomUtils;

public class RacingCarGame {


    private Cars cars;

    public RacingCarGame(Cars cars) {
        this.cars = cars;
    }

    public void run(int[] randoms){
        cars.moveCar(randoms);
    }


}
