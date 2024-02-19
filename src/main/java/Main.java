import controller.Race;
import model.RandomNumberGenerator;
import view.InputView;
import view.OutputView;

public class Main {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Race race = new Race(inputView, outputView, new RandomNumberGenerator());
        race.start();
    }
}
