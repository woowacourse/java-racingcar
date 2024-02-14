public class RacingGame {
    public static void main(String[] args) {
        Cars cars = new Cars(InputView.readCarNames());
        int count = InputView.readRoundNumber();
        for (int round = 1; round <= count; round++) {
            cars.tryMove();
            //TODO : 각 자동차의 위치를 출력할 수 있도록 수정
        }
        OutputView.showWinners(cars.getWinnersName());
    }
}
