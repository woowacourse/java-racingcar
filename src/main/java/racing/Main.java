package racing;

public class Main {
	public static void main(String[] args) {
		InputView inputView = new InputView();
		String carNames = InputView.inputCarNames(inputView.input());
		Cars cars = new Cars(InputView.splitAsComma(carNames));
		int rounds = InputView.inputRoundNumber(inputView.input());

		for (int i = 0; i < rounds; i++) {
			cars.playRound();
			cars.printPosition();
		}

		OutputView.printWinner(cars.findWinner());
	}
}
