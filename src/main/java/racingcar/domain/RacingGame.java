package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

import racingcar.utils.RandomNumber;
import racingcar.utils.StringUtils;
import racingcar.view.InputView;

public class RacingGame {

    private List<Car> racingCars;

    public RacingGame(List<Car> racingCars) {
        this.racingCars = racingCars;
    }

    public List<Car> getRacingCars() {
        return racingCars;
    }

    public void moveCar() {
        racingCars.forEach(car -> car.move(RandomNumber.generateRandomIntIntRange()));
    }

    public static List<Car> generateCars(String[] carNames) {
        checkNameNull(carNames);
        final List<Car> racingCars = new ArrayList<>(carNames.length);
        for (String carName : carNames) {
            racingCars.add(new Car(new CarName(carName)));
        }
        return racingCars;
    }

    private static void checkNameNull(String[] carNames) {
        if (carNames.length == 0) {
            throw new IllegalArgumentException("자동차 이름이 없습니다.");
        }
    }

    public static String[] generateRacingCarNames() {
        try {
            String input = InputView.inputCarNames();
            return StringUtils.splitInputName(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return generateRacingCarNames();
        }
    }

    public static int generateGameRound() {
        try {
            GameRound gameRound = new GameRound(InputView.inputGameRound());
            return gameRound.getGameRound();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return generateGameRound();
        }
    }

}
