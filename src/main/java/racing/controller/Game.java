package racing.controller;

import racing.model.Winner;
import racing.view.InputView;
import racing.view.OutputView;

public class Game {
    private final static String MSG_GAME_RESULT = "실행 결과";

    public static void main(String[] args) {
        String[] cars = InputView.carName().split(",");
        int count = InputView.gameCount();

        try {
            Racing racing = new Racing(cars, count);
            OutputView.print(MSG_GAME_RESULT);

            for (int i = 0; i < racing.getCount(); i++) {
                racing.moveCars();
                OutputView.print(racing.getCars());
            }

            Winner winner = racing.getWinners();
            OutputView.print(winner);
        } catch (IllegalArgumentException e) {
            System.exit(-1);
        }
    }
}
