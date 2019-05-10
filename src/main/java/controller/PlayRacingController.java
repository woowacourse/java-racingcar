package controller;

import domain.Race;
import view.InputView;

/**
 * Created by Heebg
 * User: heebg
 * Date: 2019-05-10
 */
public class PlayRacingController {
    public static void playRacing(){
        Race race = RacingController.moveAllCar(RacingController.setCarName(InputView.inputCarNames()), RacingController.setRoundCount(InputView.inputRoundCount()));
        RacingController.printWinners(race);
    }
}
