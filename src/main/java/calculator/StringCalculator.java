package calculator;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
	public static int splitAndSum(String input) {
		if (input == null || input.isEmpty()) {
			return 0;
		}

		String[] result = input.split(",|:");

		List<Integer> numbers = new ArrayList<>();
		for (String s : result) {
			numbers.add(Integer.parseInt(s));
		}

		int sum = 0;
		for (Integer number : numbers) {
			sum += number;
		}

		return sum;
	}
}
