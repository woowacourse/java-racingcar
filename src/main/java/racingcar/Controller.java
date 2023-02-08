package racingcar;

public class Controller {

    public static void main(String[] args) {
        try {
            RacingGame racingGame = new RacingGame();
            racingGame.playingGame();
            racingGame.viewResult();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
