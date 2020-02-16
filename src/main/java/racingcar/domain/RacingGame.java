package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingGame {

    private RacingGame() {
    }

    public static List<String> resultRacingGame(List<Car> racingCarList) {
        Winner winner = new Winner();

        return winner.getWinners(racingCarList);
    }

    public static void startRace(List<Car> racingCarList) {
        racingCarList.forEach(car -> {
            RandomNumber randomNumber = new RandomNumber(MakeRandomNumber.generateRandomIntIntRange());
            car.move(randomNumber);
        });
    }

    public static List<Car> generateCars(String[] carNames) {
        final List<Car> racingCarList = new ArrayList<>(carNames.length);

        Arrays.stream(carNames)
                .forEach(carName -> racingCarList.add(new Car(carName)));

        return racingCarList;
    }
}
