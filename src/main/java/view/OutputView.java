package view;

import java.util.List;
import model.Cars;

public class OutputView {

    private static final String DELIMITER = ", ";

    public void printResultPrefix() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void printCurrentRace(Cars cars) {
        cars.getCarList().forEach(car -> {
            System.out.printf("%s : %s\n", car.getCarName(), "-".repeat(car.getCarLocation()));
        });
        System.out.println();
    }

    public void printWinners(List<String> winnerNames) {
        System.out.println(String.join(DELIMITER, winnerNames) + "가 최종 우승했습니다.");
    }
}
