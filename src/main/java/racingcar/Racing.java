package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Racing {

    public final List<Car> cars;
    private final StringBuilder winnerString = new StringBuilder("최종 우승자 : ");
    private int gameCount;

    public Racing(List<Car> cars, int gameCount) {
        this.cars = cars;
        this.gameCount = gameCount;
    }

    public void race() {
        System.out.println("실행 결과");
        while (isLeftRacing()) {
            gameCount--;
            raceAllCar();
            printCurrentRaceResult();
        }
        printWinner();
    }

    private boolean isLeftRacing() {
        return gameCount > 0;
    }

    private void raceAllCar() {
        cars.forEach(Car::race);
    }

    private void printCurrentRaceResult() {
        cars.forEach(Car::printCurrentPosition);
        System.out.println();
    }

    private int getLeadCarPosition() {
        Car leadCar = cars.stream()
            .max(Comparator.comparing(Car::getPosition))
            .get();
        return leadCar.getPosition();
    }

    private void printWinner() {
        int leadCarPosition = getLeadCarPosition();
        buildWinnerString(leadCarPosition);
        System.out.println(winnerString);
    }

    private void buildWinnerString(int leadCarPosition) {
        List<String> winners = cars.stream()
            .filter(car -> car.getPosition() == leadCarPosition)
            .map(Car::getName)
            .collect(Collectors.toList());

        String winnerNamesString = String.join(", ", winners);
        winnerString.append(winnerNamesString);
//        winnerString.setLength(winnerString.length() - 2);
    }
}
