package racinggame;

import racinggame.view.UserInput;
import racinggame.view.resultOutput;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();

        String inputText = UserInput.inputCarsName();
        int gameCount = UserInput.inputGameCount();

        CarsName carsName = new CarsName(inputText);
        Cars cars = new Cars(carsName);
        Winner winner = game.playGames(cars, gameCount);

        resultOutput.winnersOutput(winner.getWinners());
    }
}