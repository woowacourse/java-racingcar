package racing;

import racing.control.RaceOperator;

public class RacingApplication {

    public static void main(String[] args) {
        RaceOperator raceOperator = new RaceOperator();
        raceOperator.startGame();
        raceOperator.endGame();
    }
}
