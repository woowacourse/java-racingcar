package racingcar.controller;

import racingcar.domain.Car;
import racingcar.view.Output;

import java.util.List;

public class CarController {
    public static void raceStart(List<Car> carList, int tryNum) {
        System.out.println("실행 결과");
        for(int i=0; i<tryNum; i++){
            move(carList);
            Output.racePrint(carList);
        }
    }

    private static void move(List<Car> carList) {
        for(Car car : carList) {
            car.goForward();
        }
    }
}
