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

        game.playGame(cars, tryCount);
        winner.selectWinners(cars);
        ResultOutput.printWinners(winner.getWinners());
    }
}
