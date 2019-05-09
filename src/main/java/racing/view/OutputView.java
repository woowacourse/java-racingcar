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

    public static void printWinners(List<String> winners){
        System.out.println(winners.toString().substring(1,winners.toString().length()-1)+"가 최종 우승했습니다.");
    }
}
