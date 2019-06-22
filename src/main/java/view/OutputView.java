package view;

import dto.CarDto;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    public static void printCars(List<CarDto> cars) {
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

    public static void printWinnerCars(List<CarDto> winnerCars) {
        final String nameSeparator = ",";

        List<String> names = winnerCars.stream()
                .map(CarDto::getName)
                .collect(Collectors.toList());

        System.out.println(String.join(nameSeparator, names) + " 가 최종 우승했습니다.");
    }

    public static void printGame() {
        System.out.println("실행결과");
    }
}
