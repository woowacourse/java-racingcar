import java.util.Scanner;
import racingcar.controller.RacingGame;

public class Application {

    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame();
        Scanner scanner = new Scanner(System.in);
        racingGame.play(scanner);
    }
}
