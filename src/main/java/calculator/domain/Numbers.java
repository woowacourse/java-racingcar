package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class Numbers {
	private List<Integer> numbers = new ArrayList<>();

	public Numbers(String[] inputs) {
		for (String input : inputs) {
			validate(input);
			numbers.add(Integer.parseInt(input));
		}
	}

	private void validate(String input) {
		if (Integer.parseInt(input) < 0) {
			throw new RuntimeException();
		}
	}

	public int sum() {
		return numbers.stream().reduce(0, Integer::sum);
	}
}
