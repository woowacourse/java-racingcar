import domain.RacingGame;
import view.InputView;
import view.MessageResolver;
import view.OutputView;

public class Main {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        MessageResolver messageResolver = new MessageResolver();
        OutputView outputView = new OutputView(messageResolver);
        RacingGame racingGame = new RacingGame(inputView, outputView);

        racingGame.run();
    }
}
