package racingcar.controller;

import racingcar.model.Car;
import racingcar.view.View;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    List<Car> carList=new ArrayList<>();

    public void run(){
        String[] carNames= View.inputNameOfCar();
        this.carListInit(carNames);

    }

    void carListInit(String[] carNames){
        for(String carName: carNames){
            carList.add(new Car(carName));
        }
    }

}
