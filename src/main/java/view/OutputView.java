package view;

import model.Car;
import model.Cars;

public class OutputView {
    private final String CAR_LOCATION = "-";
    private final String PRINT_CAR_LOCATION = "%s : %s\n";
    private final String PRINT_WINNER = "%s가 최종 우승했습니다.\n";

    public void printResult(Cars cars) {
        for (Car car : cars.getCars()) {
            String location = CAR_LOCATION.repeat(car.getLocation());
            System.out.printf(PRINT_CAR_LOCATION, car.getName(), location);
        }
        System.out.println();
    }

    public void printWinner(String winner) {
        System.out.printf(PRINT_WINNER, winner);
    }
}
