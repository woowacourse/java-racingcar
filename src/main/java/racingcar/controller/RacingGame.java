package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.GameResult;
import racingcar.model.Racing;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    public List<Car> setCarName(String[] name){
        //String[] name = input.inputName();
        List<Car> carList = new ArrayList<>();

        for(String carName : name){
            carList.add(new Car(carName));
        }

        return  carList;
    }

}
