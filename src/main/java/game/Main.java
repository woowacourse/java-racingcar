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

        startGame(game, winner, cars, inputMaxInstance());
        printWinnerResult(winner);
    }

    private static int inputMaxInstance() {
        return UserInput.inputGameCount();
    }

    private static void printWinnerResult(Winner winner) {
        ResultOutput.printWinners(winner.getWinners());
    }

    private static void startGame(Game game, Winner winner, List<Car> cars, int maxInstance) {
        while (!winner.checkWinner(cars, maxInstance)) {
            game.playGame(cars);
            ResultOutput.printEachGame(cars);
        }
    }
}
