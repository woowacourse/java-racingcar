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
        List<Car>  carList = new ArrayList<>();

        for(String carName : name){
            carList.add(new Car(carName));
        }

        return  carList;
    }


    private List<Car> getRacingPostion(List<Car> carList){

        Racing racing = new Racing();
        ResultView resultView = new ResultView();

        for(int i = 0 ; i < carList.size() ; i++){
            boolean position = racing.move(carList.get(i), racing.getRandomNumber());
        }


        return carList;
    }


}
