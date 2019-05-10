package domain;

import view.OutputView;

import java.util.List;

public class RacingGame {

    public void startRacing(List<Car> cars, int tryNumber) {
        OutputView.printStartUI();

        for (int i = 0; i < tryNumber; i++) {
            tryMove(cars);
            OutputView.printPosition(cars);
            System.out.println();
        }
    }

    private void tryMove(List<Car> cars) {
        for (Car car : cars) {
            if (Rule.judgeMove(Rule.makeRandomNumber()) == 1) {
                car.move();
            }
        }
    }
}
