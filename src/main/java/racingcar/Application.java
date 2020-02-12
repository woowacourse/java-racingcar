package racingcar;

import racingcar.utils.RandomNumber;

public class Application {
	public static void main(String[] args) {
		int number = RandomNumber.generateRandomIntIntRange();
		System.out.println(number);
	}
}
