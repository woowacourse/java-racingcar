package racing;


import racing.domain.Car;
import racing.domain.CarGenerator;
import racing.domain.Cars;

import java.util.List;

import static racing.view.InputView.*;
import static racing.view.OutputView.*;

public class Main {
	public static void main(String[] args) {
		CarGenerator carGenerator = new CarGenerator();
		List<Car> input = carGenerator.carGenerate(inputCarNames());
		Cars cars = new Cars(input);
		int rounds = inputRoundNumber();

		for (int i = 0; i < rounds; i++) {
			cars.playRound();
			printAllPosition(cars.getCars());
		}

		printWinner(cars.findWinner());
	}
}
