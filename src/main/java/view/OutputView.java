package view;

import domain.MovedCar;

import java.util.List;
import java.util.stream.IntStream;

public class OutputView {

    public static void printWinners(List<MovedCar> winners) {
        String [] names = winners.stream().map((MovedCar car) -> car.getName()).toArray(String []:: new);

        System.out.println(String.join("," ,names) +  " 가 최종 우승했습니다.");
    }

    public static void printCars(List<MovedCar> movedCars) {
        for (MovedCar movedCar : movedCars) {
            System.out.println(generateCarStatus(movedCar));
        }
        System.out.println();
    }

    public static void printMassage(String msg) {
        System.out.println(msg);
    }

    private static String generateCarStatus(MovedCar movedCar) {
        StringBuilder sb = new StringBuilder();

        sb.append(movedCar.getName());
        sb.append(" : ");

        IntStream.range(0, movedCar.getPosition()).forEach((i) -> sb.append("-"));

        return sb.toString();
    }
}
