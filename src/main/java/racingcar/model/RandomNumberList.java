package racingcar.model;

import racingcar.util.IntegerConst;

import java.util.ArrayList;
import java.util.Random;

public class RandomNumberList {
	private final ArrayList<Integer> randomNumberList;

	public RandomNumberList(int size) {
		this.randomNumberList = new ArrayList<>();
		Random random = new Random();
		for (int nowIndex = IntegerConst.ZERO.getValue(); nowIndex < size; nowIndex++) {
			this.randomNumberList.add(random.nextInt(IntegerConst.RANDOM_UPPER_BOUND.getValue()));
		}
	}

	public int getNumberAt(int index) {
		return this.randomNumberList.get(index);
	}
}
