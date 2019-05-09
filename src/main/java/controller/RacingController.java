package controller;

import domain.Car;
import domain.Race;
import util.Util;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingController {

    public List<Car> makeCarList(List<String> carNameList) throws IllegalArgumentException{
        Util.checkDuplicatedStringList(carNameList);
        List<Car> carList = new ArrayList<>();
        for (String carName : carNameList) {
            carList.add(new Car(carName));
        }
        return carList;
    }

    public Race moveAllCar(List<Car> carList, int roundCount){
        Race race = new Race(carList);
        OutputView.outputGameResultTile();
        for(int i = 0 ; i < roundCount ; i++){
            race.MoveAllCarOneTime();
            OutputView.outputGameResult(race.getRaceCars());
        }
        return race;
    }
}
