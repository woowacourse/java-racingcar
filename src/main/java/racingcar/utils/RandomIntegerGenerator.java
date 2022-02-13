package racingcar.utils;

public class RandomIntegerGenerator {
	public static int random(int start, int end) {
		return (int)(Math.random() * (end - start)) + start;
	}
}
