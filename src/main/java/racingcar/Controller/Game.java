package racingcar.Controller;

import racingcar.Model.Car;
import racingcar.View.InputView;
import racingcar.View.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private static final int INDEX_START = 0;

    private List<Car> cars = new ArrayList<>();
    private int trialTime;

    public void initialize() {
        String[] carNames = InputView.inputCarName();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        trialTime = InputView.inputTrialTime();
    }

    public void race() {
        OutputView.printResultMessage();
        for (int index = INDEX_START; index < trialTime; index++) {
            raceOneRound();
        }
        OutputView.printNewLine();
    }

    private void raceOneRound() {
        for (Car car : cars) {
            car.goOrNot();
            car.showCurrentPosition();
        }
    }

    public static Car findTopPositionCar(List<Car> cars) {
        StringBuilder winners = new StringBuilder();
        Car winner = cars.get(0);
        if (cars.size() == 1) {
            return winner;
        }
        for(int i = 1; i < cars.size(); i++) {
            if (!winner.comparePosition(cars.get(i))) {
                winner = cars.get(i);
            }
        }
        return winner;
    }

}
