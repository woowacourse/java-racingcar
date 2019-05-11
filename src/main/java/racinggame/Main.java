package racinggame;

import racinggame.view.UserInput;
import racinggame.view.resultOutput;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        CarGenerator cg = new CarGenerator();
        CarNameGenerator cng = new CarNameGenerator();
        String inputText = UserInput.inputCarsName();
        int gameCount = UserInput.inputGameCount();
        Winner winner;

        winner = game.playGames(cg.createCars(cng.createCarsName(inputText)), gameCount);
        resultOutput.winnersOutput(winner.getWinners());
    }
}