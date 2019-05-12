package racing.view;

import racing.domain.Car;
import racing.domain.RaceStatusDto;

import java.util.List;

public class OutputView {
    public static void printStatus(RaceStatusDto raceStatusDto) {
        List<Car> cars = raceStatusDto.getCars();
        cars.forEach(car -> System.out.println(car.getStatus()));
        System.out.println();
    }

    public static void printWinners(List<String> winners) {
        String winnerNames = String.join(",", winners);
        System.out.println(String.format(ConsoleMessages.OUTPUT_WINNER_NAME.getMessage(), winnerNames));
    }
}
