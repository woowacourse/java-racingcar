package controller;

import domain.Car;
import domain.Const;
import domain.Race;
import util.Util;
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
        List<Car> cars = setCarName(InputView.inputCarNames());
        int roundCount = setRoundCount(InputView.inputRoundCount());

        OutputView.outputGameResultTile();
        Race race = RacingController.setRacingCars(cars);
        race = outputMoveCar(race, roundCount);
        OutputView.outputWinners(race.getRaceWinners());
    }

    protected static List<Car> setCarName(String carName) {
        try {
            List<String> carNames = Arrays.asList(carName.split(","));
            Util.checkDuplicatedStringList(carNames);
            Util.checkStringListSize(carNames);
            return RacingController.setCars(Arrays.asList(carName.split(",")));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return setCarName(InputView.inputCarNames());
        }
    }

    protected static int setRoundCount(int roundCount) {
        try {
            Util.checkRoundCountRange(roundCount);
            return roundCount;
        } catch (Exception e) {
            System.out.println(Const.EX_ROUND_COUNT);
            return setRoundCount(InputView.inputRoundCount());
        }
    }

    protected static Race outputMoveCar(Race race, int roundCount) {
        for (int i = 0; i < roundCount; i++) {
            race = RacingController.moveCar(race);
            OutputView.outputGameResult(race.getRaceCarInfo());
        }
        return race;
    }
}
