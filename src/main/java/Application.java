import domain.RaceManager;
import utils.NumberGenerator;
import utils.RandomGenerator;
import view.InputView;

public class Application {
    private static final InputView inputView = new InputView(System.in);
    private static final NumberGenerator numberGenerator = new RandomGenerator();

    public static void main(String[] args) {
        RaceManager raceManager = new RaceManager(inputView, numberGenerator);
        raceManager.run();
    }
}
