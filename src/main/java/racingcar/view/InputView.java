package racingcar.view;

import racingcar.model.Car;

import java.util.ArrayList;
import java.util.Scanner;

public class InputView {

    public static ArrayList<Car> getUserCarInput(Scanner scanner){
        OutputView.readCarName();
        String userInput = scanner.nextLine();
        try {
            String[] carNames = userInput.split(",");
            return makeCars(carNames);
        }
        catch(Exception e) {
            return getUserCarInput(scanner);
        }
    }

    private static ArrayList<Car> makeCars(String[] carNames) {
        ArrayList<Car> cars = new ArrayList<Car>();
        for(String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }
}
