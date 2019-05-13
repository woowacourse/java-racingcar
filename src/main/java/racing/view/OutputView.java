package racing.view;

import racing.domain.Car;
import racing.domain.RaceStatusDto;

import java.util.List;

public class OutputView {
    public static void printStatus(RaceStatusDto raceStatusDto) {
        List<Car> cars = raceStatusDto.getCars();

        System.out.println(printStatus(cars).toString());
    }

    private static StringBuilder printStatus(List<Car> cars) {
        StringBuilder sb = new StringBuilder();
        for (Car car : cars) {
            sb.append(car.getName());
            sb.append(" : ");
            printDistanceStatus(sb, car);
            sb.append("\n");
        }
        return sb;
    }

    private static void printDistanceStatus(StringBuilder sb, Car car) {
        for (int i = 0; i < car.getDistance(); i++) {
            sb.append("-");
        }
    }

    public static void printWinners(List<String> winners) {
        String winnerNames = String.join(",", winners);
        System.out.println(String.format(ConsoleMessages.OUTPUT_WINNER_NAME.getMessage(), winnerNames));
    }
}
