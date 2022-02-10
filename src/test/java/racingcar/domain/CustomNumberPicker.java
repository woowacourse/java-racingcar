package racingcar.domain;

import java.util.Iterator;
import java.util.List;

import racingcar.controller.NumberPicker;

public class CustomNumberPicker implements NumberPicker {

	private final Iterator<Integer> iterator;

	public CustomNumberPicker(List<Integer> numbers) {
		iterator = numbers.iterator();
	}

	@Override
	public int pickNumber() {
		return iterator.next();
	}
}
