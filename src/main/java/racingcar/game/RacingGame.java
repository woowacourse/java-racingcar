package racingcar.game;

import racingcar.entity.Car;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

import static racingcar.view.InputView.getAttemptCount;
import static racingcar.view.InputView.getCarNames;

public class RacingGame {

    private List<Car> carList = new ArrayList<>();
    private int totalAttemptCount;

    public void start() {
        initRacingCarGame();
        run();
    }

    private void initRacingCarGame() {
        String[] names = getCarNames().split(",");

        for (String name : names) {
            carList.add(new Car(name));
        }

        totalAttemptCount = Integer.parseInt(getAttemptCount());
    }

}
