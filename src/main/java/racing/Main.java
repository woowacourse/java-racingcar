package racing;

import java.util.Scanner;

import racing.domain.Cars;
import racing.view.InputView;
import racing.view.OutputView;

public class Main {
	public static void main(String[] args) {
		InputView inputView = new InputView();
		Scanner input = inputView.input();
		Cars cars = new Cars(InputView.inputCarNames(input));
		int rounds = InputView.inputRoundNumber(input);

		for (int i = 0; i < rounds; i++) {
			cars.playRound();
			OutputView.printAllPosition(cars.getCars());
		}

		OutputView.printWinner(cars.findWinner());
	}
}
