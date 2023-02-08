public class RacingGame {

    public void startGame(Cars cars, int count) {
        // 메인 로직 (랜덤에 따른 전진 혹은 멈춤)
        for (int i = 0; i < count; i++) {
            cars.moveCars();
            OutputView.printState(cars);
        }

        decideWinners(cars);

    }

    public void decideWinners(Cars cars) {
        Cars winners = cars.getWinners();
        OutputView.printWinners(winners);
    }
}
