package racinggame;

import racinggame.view.UserInput;
import racinggame.view.ResultOutput;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        String inputText;
        int gameCount;
        String[] carsName;
        List<Car> cars = new ArrayList<>();

        inputText = UserInput.inputCarsName();
        gameCount = UserInput.inputGameCount();

        carsName = CarsName.makeCarsName(inputText);

        for (String carName : carsName) {
            cars.add(new Car(carName));
        }

        for (int i = 0; i < gameCount; i++) {
            game.playGame(cars);
            ResultOutput.printNewLine();
        }

        Winner winners = new Winner(cars);

        ResultOutput.winnersOutput(winners.getWinners());
    }
}