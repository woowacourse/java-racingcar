package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

import racingcar.utils.RandomNumber;
import racingcar.utils.StringUtils;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame {

    private RacingGame() {
    }

    public static void runRacingGame() {
        try {
            final List<Car> racingCarList = getCars(getRacingCarNames());
            int playRound = getRacingRound();

            startRace(playRound, racingCarList);

            List<String> winners = Winner.getWinners(racingCarList);
            OutputView.printWinners(winners);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            runRacingGame();
        }
    }

    private static void startRace(int playRound, List<Car> racingCarList) {
        for (int i = 0; i < playRound; i++) {
            for (Car car : racingCarList) {
                car.move(RandomNumber.generateRandomIntIntRange());
                OutputView.printRoundResult(car);
            }
            System.out.println();
        }
    }

    private static List<Car> getCars(String[] carNames) {
        final List<Car> racingCars = new ArrayList<>(carNames.length);
        for (String carName : carNames) {
            racingCars.add(new Car(new CarName(carName)));
        }
        return racingCars;
    }

    private static String[] getRacingCarNames() {
        try {
            String input = InputView.getCarNames();
            return StringUtils.splitInputName(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getRacingCarNames();
        }
    }

    private static int getRacingRound() {
        try {
            GameRound gameRound = new GameRound(InputView.getPlayRound());
            return gameRound.getGameRound();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getRacingRound();
        }
    }

}
