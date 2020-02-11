package calculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import calculator.utils.Split;

public class Calculator {

	public static Double calculate(String value) {
		String[] numbers = parse(value);
		Double result = sumNumber(numbers);

		return result;
	}

	private static Double sumNumber(String[] numbers) {
		List<Double> numbersToDouble = Arrays.stream(numbers).map(Double::parseDouble).collect(Collectors.toList());

		return numbersToDouble.stream().mapToDouble(Double::doubleValue).sum();
	}

	private static String[] parse(String value) {
		if (value.startsWith("//")) {
			return Split.splitNumberByCustomByDelimiter(value);
		}
		return Split.splitByCommaOrColon(value);
	}

}
