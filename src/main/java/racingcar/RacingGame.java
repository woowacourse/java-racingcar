package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private static final String WINNER_NAME_DELIMITER = ", ";

    public RacingGame() {
    }

    public RacingGame(String carNames, String tryCount) {
        RacingCars racingCars = new RacingCars();
        racingCars.join(carNames);
    }

    public void playGame(RacingCars racingCars, int trialCount) {
        for (int i = 0; i < trialCount; i++) {
            moveCar(racingCars);
        }
    }

    private void moveCar(RacingCars racingCars) {
        for (RacingCar racingCar : racingCars.getRacingCars()) {
            racingCar.goOrStay(RandomGenerator.generateRandomNumber());
        }
    }

    public ArrayList<RacingCar> getWinners(RacingCars racingCars) {

        RacingCar racingCarOfMaxPosition = racingCars.getRacingCarMaxPosition();
        List<RacingCar> racingCarList = racingCars.getRacingCars();
        ArrayList<RacingCar> winners = new ArrayList<>();

        for (RacingCar racingCar : racingCarList) {
            if (racingCar.isSamePosition(racingCarOfMaxPosition)) {
                winners.add(racingCar);
            }
        }
        return winners;
    }

    public String getWinnersName(ArrayList<RacingCar> winners) {
        ArrayList<String> winnersName = new ArrayList<>();
        for (RacingCar winner : winners) {
            winnersName.add(winner.getName());
        }
        return String.join(WINNER_NAME_DELIMITER, winnersName);
    }
}
