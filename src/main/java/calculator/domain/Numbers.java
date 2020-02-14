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
			throw new RuntimeException("0 또는 음수는 입력 할 수 없습니다.\n");
		}
	}

	public int sum() {
		return numbers.stream().reduce(0, Integer::sum);
	}
}
