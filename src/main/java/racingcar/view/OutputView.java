package racingcar.view;

import java.util.List;

import racingcar.dto.CarDto;

public class OutputView {
    public static void printRaceResult() {
        System.out.format("%n실행 결과%n");
    }

    public static void printCars(List<CarDto> carsInformation) {
        for (CarDto carInformation : carsInformation) {
            System.out.println(carInformation.getName() + " : " + "-".repeat(carInformation.getPosition()));
        }
    }

    public static void printEnter() {
        System.out.println();
    }

    public static void printWinners(List<String> names) {
        System.out.printf("%s가 최종 우승했습니다.", String.join(", ", names));
    }

    public static void printError(Exception exception) {
        System.out.println(exception.getMessage());
    }
}
