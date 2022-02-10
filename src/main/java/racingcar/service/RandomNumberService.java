package racingcar.service;

public class RandomNumberService {
	public static int getRandomNumber() {
		int random = (int)(Math.random() * 10);
		return random;
	}
}
