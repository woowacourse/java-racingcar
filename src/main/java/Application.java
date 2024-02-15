import domain.RaceManager;
import view.InputView;

public class Application {
    private static final InputView inputView = new InputView(System.in);

    public static void main(String[] args) {
        RaceManager raceManager = new RaceManager(inputView);
        raceManager.run();
    }
}
