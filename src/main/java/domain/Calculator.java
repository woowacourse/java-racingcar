package domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Calculator {

	public static Double calculate(String[] numbers) {
		List<Double> numbersToDouble = Arrays.stream(numbers).map(Double::parseDouble).collect(Collectors.toList());

		return numbersToDouble.stream().mapToDouble(Double::doubleValue).sum();
	}

}
