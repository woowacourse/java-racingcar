package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private static final String WINNER_NAME_DELIMITER = ", ";

    public RacingGame() {
    }

    public void playGame(RacingCars racingCars, int trialCount) {
        OutputView.printGameStartMessage();
        for (int i = 0; i < trialCount; i++) {
            moveCar(racingCars);
            OutputView.printCurrentRacingSituation(racingCars);
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
