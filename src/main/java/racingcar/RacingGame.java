package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    public void moveCar(RacingCar car) {
        car.goOrStay(RandomGenerator.generateRandomNumber());
    }

    public ArrayList<RacingCar> getWinners(RacingCars racingCars) {

        RacingCar racingCarOfMaxPosition = racingCars.getRacingCarMaxPosition();
        List<RacingCar> racingCarList = racingCars.getRacingCars();
        ArrayList<RacingCar> winners = new ArrayList<>();

        for (RacingCar racingCar : racingCarList) {
            if(racingCar.isSamePosition(racingCarOfMaxPosition)){
                winners.add(racingCar);
            }
        }
        return winners;
    }
}
