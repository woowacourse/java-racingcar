import racingCar.Car;
import racingCar.Cars;
import racingCar.CarName;
import racingCar.RacingCarGame;
import utils.RandomUtils;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGameMain {
    private static final int MINIMUM_VALUE = 0;
    private static final int MAXIMUM_VALUE = 9;

    private static Cars cars;

    public static void main(String[] args) {
        cars = new Cars(initCars());
        int tryNumber = InputView.getTryNumber();

        RacingCarGame racingCarGame = new RacingCarGame(cars);
        start(racingCarGame, tryNumber);

        List<CarName> winners = cars.findWinners(cars.findMaxDistance());

        OutputView.showResult(winners);
    }

    private static void start(RacingCarGame racingCarGame, int tryNumber) {
        for (int i = 0; i < tryNumber; i++) {
            racingCarGame.run(randoms());
            OutputView.showStatus(cars.getCars());
        }
    }

    private static List<Car> initCars() {
        List<Car> cars = new ArrayList<>();
        String[] carNames = InputView.getInput().split(",");
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    private static int[] randoms() {
        int[] randoms = new int[cars.getCars().size()];

        for (int i = 0; i < randoms.length; i++) {
            randoms[i] = RandomUtils.nextInt(MINIMUM_VALUE, MAXIMUM_VALUE);
        }
        return randoms;
    }
}
