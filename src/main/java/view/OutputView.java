package view;

import dto.CarDto;
import dto.CarsDto;
import dto.RacingGameDto;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    public static void printGame(RacingGameDto racingGameDto) {
        System.out.println("실행결과");

        for (CarsDto cars : racingGameDto.getCarsDtosFromFirstTrial()) {
            printCars(cars);
        }
        printWinnerCars(racingGameDto.getWinningCarsDto());
    }

    private static void printCars(CarsDto cars) {
        for (CarDto car : cars) {
            System.out.println(toString(car));
        }
        System.out.println();
    }

    private static String toString(CarDto car) {
        final String CAR_DISTANCE_MARKER = "-";

        StringBuilder sb = new StringBuilder();

        sb.append(car.getName());
        sb.append(" : ");
        for (int i = 0; i < car.getDistance(); i++) {
            sb.append(CAR_DISTANCE_MARKER);
        }

        return sb.toString();
    }

    private static void printWinnerCars(CarsDto winnerCars) {
        final String nameSeparator = ",";

        List<String> names = winnerCars.getCars().stream()
                .map(CarDto::getName)
                .collect(Collectors.toList());

        System.out.println(String.join(nameSeparator, names) + " 가 최종 우승했습니다.");
    }
}
