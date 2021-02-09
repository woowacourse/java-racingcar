package car;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameController {
    final Scanner scanner = new Scanner(System.in);
    final String delimiter = ",";
    private OutputView message = new OutputView();

    public void start() {
        int round = 0;
        List<Car> carNames = new ArrayList<>();
        try {
            carNames = inputCarName();
            round = inputRound();
        } catch (IllegalArgumentException error) {
            message.errorPrint();
            start();
        }
        moveCar(carNames, round);
    }

    private int inputRound() {
        message.repeatGuidePrint();
        String roundInput = scanner.nextLine();
        ValidCheck.round(roundInput);
        return Integer.parseInt(roundInput);
    }

    private List<Car> inputCarName() {
        List<Car> carNames = new ArrayList<>();

        message.carNameGuidePrint();
        String carNamesInput = scanner.nextLine();
        ValidCheck.carNameValid(carNamesInput);
        for (String carName : carNamesInput.split(delimiter)) {
            carNames.add(new Car(carName));
        }
        return carNames;
    }

    private void moveCar(List<Car> carNames, int round) {
        message.roundStart();
        for (int i = 0; i < round; i++) {
            carNames.forEach(Car::moveOrStop);
            message.printResult(carNames);
        }
        printWinner(carNames);
    }

    private void printWinner(List<Car> carNames) {
        message.printWinners(carNames);
    }

}
