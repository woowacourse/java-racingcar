package view;

import domain.Car;
import domain.Count;
import domain.RaceCars;
import domain.RacingGame;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String FORMAT = "%s : %s";

    public void printResultNotice() {
        System.out.println("\n실행 결과");
    }

    public void printRace(RacingGame racingGame) {
        Count count = racingGame.getCount();
        for (int round = 1; round <= count.getCount(); round++) {
            printLocation(racingGame.getRaceCars(), round);
        }
    }

    private void printLocation(RaceCars raceCars, int round) {
        for (int i = 0; i < raceCars.getCarCount(); i++) {
            Car car = raceCars.getCar(i);
            int location = car.getLocation(round);
            String result = String.format(FORMAT, car.getName(), "-".repeat(location));
            System.out.println(result);
        }
        System.out.println();
    }

    public void printWinners(List<Car> winners) {
        String winnerNotice = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", ", "", "가 최종 우승했습니다."));
        System.out.println(winnerNotice);
    }
}
