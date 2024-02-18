package view;

import domain.Car;
import domain.CarGroup;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    // 정책 변경 가능성 있는 상수 분리
    private static final String CAR_POSITION_MARK = "-";
    private static final String WINNERS_NAME_DELIMITER = ", ";

    public static void printRaceResultHeader() {
        System.out.println("\n실행 결과");
    }

    public static void printCarsPosition(final CarGroup carGroup) {
        final List<Car> cars = carGroup.getAllCars();

        cars.forEach(car -> {
                    final String carName = car.getName();
                    final int carPosition = car.getPosition();
                    System.out.println(carName + " : " + CAR_POSITION_MARK.repeat(carPosition));
                }
        );
        System.out.println();
    }

    public static void printResult(final CarGroup carGroup) {
        final List<Car> winners = carGroup.getWinners();

        if (winners.size() == 0) {
            System.out.println("우승자가 없습니다.");
            return;
        }

        final List<String> winnerNames = winners.stream()
                .map(Car::getName)
                .collect(Collectors.toList());

        final String result = String.join(WINNERS_NAME_DELIMITER, winnerNames).concat("가 최종 우승했습니다.");
        System.out.println(result);
    }

    public static void printExceptionMessage(final Exception ex) {
        System.out.println(ex.getMessage());
    }
}
