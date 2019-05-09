package racing.control;

import racing.domain.Race;
import racing.domain.RaceResult;
import racing.view.InputView;

public class RaceOperator {
    private static Race race;
    private static RaceResult raceResult;

    public static void setupGame() {
        race = new Race();
        race.createCars(InputView.requestNames());
        race.inputNumTrials();
    }

    public static void startGame(){
        
    }
}
