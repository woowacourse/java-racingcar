package view;

import domain.Car;
import domain.Count;
import domain.RaceCars;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class OutputView {
    private static final String FORMAT = "%s : %s";

    public void printResultNotice() {
        System.out.println("\n실행 결과");
    }

    public void printRace(RaceCars raceCars, Count count) {
        for (int round = 1; round <= count.getCount(); round++) {
            Consumer<Car> printLocation = getLocation(round);
            raceCars.run(printLocation);
            System.out.println();
        }
    }

    private Consumer<Car> getLocation(int round) {
        return car -> {
            int location = car.getLocation(round);
            String result = String.format(FORMAT, car.getName(), "-".repeat(location));
            System.out.println(result);
        };
    }

    public void printWinners(List<Car> winners) {
        String winnerNotice = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", ", "", "가 최종 우승했습니다."));
        System.out.println(winnerNotice);
    }
}
