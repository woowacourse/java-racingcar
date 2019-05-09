package game;

import game.input.UserInput;
import game.output.resultOutput;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        Winner winner = new Winner();
        String[] carNames;
        List<Car> cars;
        int maxInstance;

        do {
            carNames = game.splitWithComma(UserInput.inputCarNames());
        } while (!game.checkCarNamesLength(carNames));

        cars = game.createCarObject(carNames);
        maxInstance = UserInput.inputGameCount();

        while (!winner.checkWinner(cars, maxInstance)) {
            game.oneGame(cars);
        }

        resultOutput.winnersOutput(winner.getWinners());
    }
}
