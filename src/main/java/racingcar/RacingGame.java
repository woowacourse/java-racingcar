package racingcar;

import racingcar.domain.RacingCar;
import racingcar.domain.RacingCars;
import racingcar.validator.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private static final String WINNER_NAME_DELIMITER = ", ";
    private final RacingCars racingCars;

    public RacingGame() {
        this.racingCars = new RacingCars();
    }

    public RacingGame(RacingCars racingCars) {
        this.racingCars = racingCars;
    }

    public void playGame(RacingCars racingCars) {

        String tryCount = InputView.askTryCount();
        Validator.checkTryCountIsNaturalNumber(tryCount);
        int trialCount = Validator.convertToInt(tryCount);

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

    public String getWinnersName() {
        ArrayList<RacingCar> winners = getWinners(racingCars);
        ArrayList<String> winnersName = new ArrayList<>();
        for (RacingCar winner : winners) {
            winnersName.add(winner.getName());
        }
        return String.join(WINNER_NAME_DELIMITER, winnersName);
    }

    private ArrayList<RacingCar> getWinners(RacingCars racingCars) {

        RacingCar racingCarOfMaxPosition = racingCars.getRacingCarWithMaxPosition();
        List<RacingCar> racingCarList = racingCars.getRacingCars();
        ArrayList<RacingCar> winners = new ArrayList<>();

        for (RacingCar racingCar : racingCarList) {
            if (racingCar.isSamePosition(racingCarOfMaxPosition)) {
                winners.add(racingCar);
            }
        }
        return winners;
    }
}
