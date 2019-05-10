package controller;

import domain.Car;
import domain.Const;
import domain.Race;
import util.Util;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Heebg
 * User: heebg
 * Date: 2019-05-08
 */
public class RacingController {
    protected static List<Car> setCarName(String carNames) {
        try {
            return inputCarNames(Arrays.asList(carNames.split(",")));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return setCarName(InputView.inputCarNames());
        }
    }

    protected static List<Car> inputCarNames(List<String> carNameList) throws IllegalArgumentException {
        Util.checkDuplicatedStringList(carNameList);
        Util.checkStringListSize(carNameList);
        List<Car> carList = new ArrayList<>();
        for (String carName : carNameList) {
            carName = carName.trim();
            carList.add(new Car(carName));
        }
        return carList;
    }

    protected static int setRoundCount(int roundCount) {
        try {
            return inputRoundCount(roundCount);
        } catch (Exception e) {
            System.out.println(Const.EX_ROUND_COUNT);
            return setRoundCount(InputView.inputRoundCount());
        }
    }

    protected static int inputRoundCount(int roundCount) throws IllegalArgumentException{
        if(roundCount <= Const.ZERO){
            throw new IllegalArgumentException();
        }
        return roundCount;
    }

    protected static Race moveAllCar(List<Car> carList, int roundCount) {
        Race race = new Race(carList);
        OutputView.outputGameResultTile();
        for (int i = 0; i < roundCount; i++) {
            race.moveAllCarOneTime();
            OutputView.outputGameResult(race.getRaceCars());
        }
        return race;
    }

    protected static void printWinners(Race race) {
        OutputView.outputWinners(race.getRaceWinners());
    }
}
