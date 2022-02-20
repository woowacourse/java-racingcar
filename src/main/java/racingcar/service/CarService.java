package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.util.RandomUtil;
import racingcar.view.Output;
import java.util.List;

public class CarService {
    public static void startRace(final List<Car> cars, final int tryNum) {
        Output.printResultWord();

        for (int i = 0; i < tryNum; i++) {
            moveCar(cars);
            printRace(cars);
        }
    }

    public static void printRace(final List<Car> cars) {
        Output.printCarsRace(cars);
    }

    public static void findFinalWinner(final List<Car> cars, RacingGame racingGame) {
        int maxPosition = findMaxPosition(cars);
        Output.printWinner(getWinners(cars, maxPosition, racingGame));
    }

    private static void moveCar(final List<Car> cars) {
        for (Car car : cars) {
            car.goForward(RandomUtil.getRandomNum());
        }
    }

    private static List<String> getWinners(final List<Car> cars, final int maxPosition, RacingGame racingGame) {
        for (Car car : cars) {
            if (car.checkIfPositionSame(maxPosition)) {
                racingGame.addWinner(car.getName());
            }
        }

        return racingGame.getWinners();
    }

    private static int findMaxPosition(final List<Car> cars) {
        int maxNum = 0;

        for (Car car : cars) {
            if (car.getPosition() > maxNum) {
                maxNum = car.getPosition();
            }
        }

        return maxNum;
    }
}
