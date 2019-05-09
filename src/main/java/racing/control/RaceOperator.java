package racing.control;

import racing.domain.Race;
import racing.domain.RaceResult;
import racing.view.InputView;

public class RaceOperator {
    private static Race race;
    public static void setupGame() {
        race = new Race();
        race.createCars();
        race.inputNumTrials();
    }

    public static void startGame(){
        race.repeatRace();
    }

    public static void endGame() {
        race.getResult().printWinners();
    }
}
