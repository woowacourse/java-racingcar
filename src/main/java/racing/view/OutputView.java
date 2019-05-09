package racing.view;

import racing.domain.Car;
import racing.domain.RaceStatusDto;

import java.util.List;

public class OutputView {

    public static void printStatus(RaceStatusDto raceStatusDto){
        List<Car> carList = raceStatusDto.getCarList();
        for (Car car : carList){
            System.out.println(car.getStatus());
        }
    }
}
