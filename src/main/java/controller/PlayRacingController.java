package controller;

import domain.Car;
import domain.Const;
import domain.Race;
import domain.Winners;
import view.InputView;
import view.OutputView;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Heebg
 * User: heebg
 * Date: 2019-05-10
 */
public class PlayRacingController {
    public static void playRacing() {
        Race race = new Race(setCarName(InputView.inputCarNames()), setRoundCount(InputView.inputRoundCount()));
        OutputView.outputGameResultTile();
        OutputView.outputWinners(playRacing(race).getWinnersName());
    }

    protected static List<Car> setCarName(String carName) {
        try {
            return RacingController.setCars(Arrays.asList(carName.split(",")));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return setCarName(InputView.inputCarNames());
        }
    }

    protected static int setRoundCount(int roundCount) {
        try {
            return RacingController.setRoundCount(roundCount);
        } catch (Exception e) {
            System.out.println(Const.EX_ROUND_COUNT);
            return setRoundCount(InputView.inputRoundCount());
        }
    }

    protected static Winners playRacing(Race race) {
        while (race.hasNextRound()) {
            OutputView.outputGameResult(RacingController.moveCar(race));
        }
        return race.winners();
    }
}
