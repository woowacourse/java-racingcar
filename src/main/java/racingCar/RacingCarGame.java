package racingCar;

import utils.RandomUtils;

public class RacingCarGame {
    private static final int MINIMUM_VALUE = 0;
    private static final int MAXIMUM_VALUE = 9;

    private Cars cars;

    public RacingCarGame(Cars cars) {
        this.cars = cars;
    }

    public void run(){
        cars.moveCar(randoms());
    }

    private int[] randoms() {
        int[] randoms = new int[cars.getCars().size()];

        for(int i = 0; i < randoms.length; i++) {
            randoms[i] = RandomUtils.nextInt(MINIMUM_VALUE,MAXIMUM_VALUE);
        }
        return randoms;
    }
}
