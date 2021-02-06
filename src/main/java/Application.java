import racingCar.Game;
import racingCar.InputChecker;

public class Application {
    public static void main(String[] args) {
        String input = InputChecker.getInput();
        int count = InputChecker.getNumber();
        Game game = new Game(input, count);
        game.run();
    }
}
