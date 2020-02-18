package application.racingGame;

import java.util.List;
import java.util.Random;

public class Race {
    private static final int MAXIMUM_RANDOM_NUMBER_RANGE = 10;

    public List<String> run(RaceParticipants raceParticipants, int racingLab) {
        Winners winners = new Winners();
        for (int i = 0; i<racingLab; i++) {
            moveCarForward(raceParticipants.getCars());
            OutputRacingView.printPositionDuringRacing(raceParticipants.getCars());
        }
        return winners.getNamesOfWinners(raceParticipants.getCars());
    }

    private void moveCarForward(List<Car> cars) {
        for (Car car : cars) {
            int randomNumber = generateRandomNumber();
            car.moveForward(randomNumber);
        }
    }

    private int generateRandomNumber() {
        Random randomNumber = new Random();
        return randomNumber.nextInt(MAXIMUM_RANDOM_NUMBER_RANGE);
    }
}
