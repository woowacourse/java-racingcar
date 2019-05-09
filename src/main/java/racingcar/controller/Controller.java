package racingcar.controller;

import racingcar.model.CarList;


public class Controller {

    public void run(String[] carNames, int numberOfTry) {
        CarList carList=new CarList(carNames,numberOfTry);
        carList.moveCarsByNumberOfTry();
    }

}
