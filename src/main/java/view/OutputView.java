package view;

import domain.Car;
import domain.CarGroup;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String CAR_POSITION_MARK = "-";

    public static void printRaceResultHeader() {
        System.out.println("\n실행 결과");
    }

    public static void printCarsPosition(CarGroup carGroup) {
        carGroup.getAllCars().forEach(car -> {
                    String carName = car.getName();
                    int carPosition = car.getPosition();
                    System.out.println(carName + " : " + CAR_POSITION_MARK.repeat(carPosition));
                }
        );
        System.out.println();
    }

    public static void printResult(CarGroup carGroup) {
        List<Car> winners = carGroup.getWinners();

        if (winners.size() == 0) {
            System.out.println("우승자가 없습니다.");
            return;
        }

        List<String> winnerNames = winners.stream()
                .map(Car::getName)
                .collect(Collectors.toList());

        String result = String.join(", ", winnerNames).concat("가 최종 우승했습니다.");
        System.out.println(result);
    }
}
