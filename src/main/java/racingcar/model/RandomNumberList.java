package racingcar.model;

import java.util.List;

import java.util.ArrayList;
import java.util.Random;

public class RandomNumberList {
	private static final int RANDOM_UPPER_BOUND = 10;
	private final List<Integer> randomNumberList;

	public RandomNumberList(int size) {
		this.randomNumberList = new ArrayList<>();
		Random random = new Random();
		for (int nowIndex = 0; nowIndex < size; nowIndex++) {
			this.randomNumberList.add(random.nextInt(RANDOM_UPPER_BOUND));
		}
	}

	public int getNumberAt(int index) {
		return this.randomNumberList.get(index);
	}
}
