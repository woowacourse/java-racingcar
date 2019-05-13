package game;

import game.create.CarsGenerator;
import game.input.UserInput;
import game.input.UserInputCheck;
import game.output.ResultOutput;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        Winner winner = new Winner();
        String[] carNames = UserInput.inputCarNames();
        List<Car> cars = CarsGenerator.createCars(carNames);
        int tryCount = UserInput.inputTryCount();

        game.playGame(cars, tryCount);
        winner.selectWinners(cars);
        ResultOutput.printWinners(winner.getWinners());
    }
}
