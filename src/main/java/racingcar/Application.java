package racingcar;

public class Application {
    public static void main(String[] args) {
        InputView inputView=new InputView();
        Game game=new Game(inputView);
        game.play();
    }
}
