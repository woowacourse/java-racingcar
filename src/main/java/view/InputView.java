package view;

import car.Car;
import domain.ValidCheck;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final String delimiter = ",";
    private final Scanner scanner = new Scanner(System.in);
    private OutputView message = new OutputView();

    public List<Car> getCarNames() {
        List<Car> carNames = new ArrayList<>();

        message.carNameGuidePrint();
        String carNamesInput = scanner.nextLine();
        ValidCheck.carNameValid(carNamesInput);
        for (String carName : carNamesInput.split(delimiter)) {
            carNames.add(new Car(carName));
        }
        return carNames;
    }

    public int getRound() {
        message.repeatGuidePrint();
        String roundInput = scanner.nextLine();
        ValidCheck.roundValid(roundInput);
        return Integer.parseInt(roundInput);
    }
}
