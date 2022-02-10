package racingcar;

public class Application {
    InputController inputController = new InputController();
    RaceController raceController = new RaceController();

    public static void main(String[] args) {
        Application application = new Application();
        application.run();
    }

    private void gameStart() throws RuntimeException {
        String[] carNames = inputController.getUserCarNames();
        int tryCount = inputController.getUserTryCount();
        raceController.insertCarFromCarNames(carNames);
        OutputView.printResultPrefix();
        for (int i = 0; i < tryCount; i++) {
            raceController.moveRound();
            raceController.printPosition();
        }
        raceController.printWinner();
    }

    private void run() {
        try {
            gameStart();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
