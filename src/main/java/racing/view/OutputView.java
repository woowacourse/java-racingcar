package racing.view;

import racing.domain.Car;
import racing.domain.RaceStatusDto;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    public static void printStatus(RaceStatusDto raceStatusDto) {
        List<Car> carList = raceStatusDto.getCarList();
        for (Car car : carList) {
            System.out.println(car.getStatus());
        }
        System.out.println();
    }

    public static void printWinners(List<String> winners) {
        String winnerNames = winners.stream().collect(Collectors.joining(","));
        System.out.println(String.format(ConsoleMessages.OUTPUT_WINNER_NAME.getMessage(), winnerNames));
    }
}
