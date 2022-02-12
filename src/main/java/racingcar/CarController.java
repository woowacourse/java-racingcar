package racingcar;

import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.*;

import static java.util.stream.Collectors.toList;

public class CarController {

    private static final String DELIMITER = ",";

    public void run() {
        RacingGame racingGame = new RacingGame();

        String carNames = getCarNamesFromUser();
        int count = getCountFromUser();

        List<Car> cars = makeCars(carNames.split(DELIMITER));

        racingGame.play(count, cars);
        OutputView.printWinners(racingGame.findWinners(cars));
    }

    private List<Car> makeCars(String[] names) {
        return Arrays.stream(names)
                .map(Car::new)
                .collect(toList());
    }

    private int getCountFromUser() {
        try {
            return InputView.getCount();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getCountFromUser();
        }
    }

    private String getCarNamesFromUser() {
        try {
            return InputView.getCarNames();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getCarNamesFromUser();
        }
    }
}