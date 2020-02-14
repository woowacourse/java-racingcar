package racing;


import racing.domain.Cars;
import static racing.view.InputView.*;
import static racing.view.OutputView.*;

public class Main {
	public static void main(String[] args) {
		Cars cars = new Cars(inputCarNames());
		int rounds = inputRoundNumber();

		for (int i = 0; i < rounds; i++) {
			cars.playRound();
			printAllPosition(cars.getCars());
		}

		printWinner(cars.findWinner());
	}
}
