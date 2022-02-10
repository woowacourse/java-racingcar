package racingcar;

public class Application {
    InputController inputController = new InputController();
    RaceController raceController = new RaceController();

    public static void main(String[] args) {
        Application application = new Application();
        application.run();
    }

    private void run() {
        String[] carNames = inputController.getUserCarNames();
        int tryCount = inputController.getUserTryCount();
        raceController.insertCarFromCarNames(carNames);
        for (int i = 0; i < tryCount; i++) {
            raceController.moveRound();
            raceController.printPosition();
        }
        raceController.printWinner();
    }
}
