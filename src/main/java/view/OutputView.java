package view;

import model.Car;
import model.Cars;

public class OutputView {
    private final String CAR_LOCATION = "-";
    private final String PRINT_CAR_LOCATION = "%s : %s\n";

    public void printResult(Cars cars){
        for(Car car : cars.getCars()){
            String location = CAR_LOCATION.repeat(car.getCarLocation());
            System.out.printf(PRINT_CAR_LOCATION, car.getCarName(), location);
        }
        System.out.println();
    }

    public void printWinner(Cars cars) {
        System.out.println(String.join(", ", cars.getWinners()));
    }
}
