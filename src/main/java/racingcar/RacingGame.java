package racingcar;

public class RacingGame {

    public void moveCar(RacingCar car) {
        car.goOrStay(RandomGenerator.generateRandomNumber());
    }
}
