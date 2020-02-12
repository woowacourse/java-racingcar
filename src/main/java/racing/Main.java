package racing;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		InputView inputView = new InputView();
		Scanner input = inputView.input();
		Cars cars = new Cars(InputView.inputCarNames(input));
		int rounds = InputView.inputRoundNumber(input);

		for (int i = 0; i < rounds; i++) {
			cars.playRound();
			cars.printPosition();
		}

		OutputView.printWinner(cars.findWinner());
	}
}
