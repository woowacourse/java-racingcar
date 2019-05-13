package game;

import game.input.UserInput;
import game.input.UserInputCheck;
import game.output.ResultOutput;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        Winner winner = new Winner();
        List<Car> cars = game.createCars(UserInput.inputCarNames());
        int tryCount = UserInput.inputTryCount();

        startGame(game, winner, cars, tryCount);
        ResultOutput.printWinners(winner.getWinners());
    }

    private static void startGame(Game game, Winner winner, List<Car> cars, int maxInstance) {
        while (!winner.checkWinner(cars, maxInstance)) {
            game.playGame(cars);
            ResultOutput.printEachGame(cars);
        }
    }
}
