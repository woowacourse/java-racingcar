package controller;

import domain.Car;
import domain.Race;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Heebg
 * User: heebg
 * Date: 2019-05-08
 */
public class RacingController {
    protected static List<Car> setCars(List<String> carNameList) {
        List<Car> carList = new ArrayList<>();
        for (String carName : carNameList) {
            carName = carName.trim();
            carList.add(new Car(carName));
        }
        return carList;
    }

    protected static Race moveAllCar(List<Car> carList, int roundCount) {
        Race race = new Race(carList);
        OutputView.outputGameResultTile();
        for (int i = 0; i < roundCount; i++) {
            race.moveAllCarOneTime();
            OutputView.outputGameResult(race.getRaceCarInfo());
        }
        return race;
    }
}
