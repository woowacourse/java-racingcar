public class RacingGame {
    public static void main(String[] args) {
        Cars cars = createCars();
        int count = initCount();
        OutputView.showRoundStart();
        for (int round = 1; round <= count; round++) {
            cars.tryMove();
            OutputView.showRoundResult(cars.getRoundResult());
        }
        OutputView.showWinners(cars.getWinnersName());
    }

    private static int initCount() {
        while (true) {
            try {
                return InputView.readRoundNumber();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static Cars createCars() {
        while (true) {
            try {
                return new Cars(InputView.readCarNames());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
