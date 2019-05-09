package racing;

import racing.control.RaceOperator;

public class RacingApplication {

    public static void main(String[] args) {
        RaceOperator.setupGame();
        RaceOperator.startGame();
        RaceOperator.endGame();
    }
}
