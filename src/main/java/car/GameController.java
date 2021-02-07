package car;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameController {

    private Scanner scanner;

    public GameController(Scanner scanner) {
        this.scanner = scanner;
    }

    public void start() {
        final String delimiter = ",";
        int round = 0;
        List<Car> carNames = new ArrayList<>();
        String[] carNamesSplit = null;

        String carNamesInput = scanner.nextLine();

        try {
            ValidCheck.carNameValid(carNamesInput);
            carNamesSplit = carNamesInput.split(delimiter);

            String roundInput = scanner.nextLine();

            ValidCheck.round(roundInput);
            round = Integer.parseInt(roundInput);

        } catch (IllegalArgumentException error) {
            OutputView message = new OutputView();
            message.errorPrint();
            start();
        }

        for (String carName : carNamesSplit) {
            carNames.add(new Car(carName));
        }

        moveCar(carNames, round);
    }

    private void moveCar(List<Car> carNames, int round) {
        OutputView outputView = new OutputView();
        outputView.roundStart();
        for (int i = 0; i < round; i++) {
            carNames.forEach(Car::moveOrStop);
            outputView.printResult(carNames);
        }
        outputView.printWinners(carNames);
    }
}
