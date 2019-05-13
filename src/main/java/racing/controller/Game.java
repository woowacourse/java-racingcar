package racing.controller;

import racing.model.Winner;
import racing.view.InputView;
import racing.view.OutputView;

public class Game {
    public static void main(String[] args) {
        String[] cars = InputView.carName().split(",");
        int count = InputView.gameCount();

        try {
            Racing racing = new Racing(cars, count);
            Winner winner = racing.run();
            OutputView.print(winner);
        } catch (IllegalArgumentException e) {
            System.exit(-1);
        }
    }
}
