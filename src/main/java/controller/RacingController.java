package controller;

import domain.Car;
import domain.Race;
import domain.Winners;
import util.Util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Heebg
 * User: heebg
 * Date: 2019-05-08
 */
public class RacingController {
    protected static List<Car> setCars(List<String> carNameList) {
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
        Util.checkRoundCountRange(roundCount);
        return roundCount;
    }

    protected static Race setRacingCars(List<Car> carList) {
        Race race = new Race(carList);
        return race;
    }

    protected static List<String> moveCar(Race race) {
        race.moveAllCarOneTime();
        return race.getRaceCarInfo();
    }
}
