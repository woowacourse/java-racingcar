package racingcar.controller;

import racingcar.dto.Car;

import java.util.ArrayList;
import java.util.List;

public class CarGenerator {
    List<Car> carList;

    CarGenerator(){
        carList = new ArrayList<>();
    }
    public void generateCars(String[] carNames){
        for(String carName : carNames){
            carList.add(new Car(carName));
        }
    }
}
