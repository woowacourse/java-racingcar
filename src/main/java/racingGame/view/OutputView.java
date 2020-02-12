package racingGame.view;

import racingGame.domain.Car;
import racingGame.domain.Cars;

import java.util.ArrayList;
import java.util.List;

public class OutputView {
    public static void printCars(Cars cars) {
        for(Car individualCar : cars.getCars()){
            System.out.println(individualCar.toString());
        }
        System.out.println();
    }

    public static void printWinners(List<Car> winners) {
        String result = String.join(",",extractWinnersName(winners));

        System.out.println(result+"가 최종 우승했습니다.");
    }

    private static List<String> extractWinnersName(List<Car> winners) {
        List<String> names = new ArrayList<>();

        for( Car winner : winners){
            names.add(winner.toStringOnlyName());
        }
        return names;
    }
}
