package calculator;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StringCalculator {
	private static final Scanner SCANNER = new Scanner(System.in);
	private static final String DELIMITER = " ";
	private static final String STRING_INPUT_MESSAGE = "사칙연산 공식을 입력해 주십시오 :";

	private Map<String, Operation> operationMap = new HashMap<>();

	public StringCalculator() {
		operationMap.put("+", new Add());
		operationMap.put("-", new Subtract());
		operationMap.put("*", new Multiply());
		operationMap.put("/", new Divide());
	}

	public void run() {
		String formula = inputFormula();
		String[] inputData = formula.split(DELIMITER);
		int result = calculate(inputData);

		System.out.println(result);
	}

	private String inputFormula() {
		System.out.println(STRING_INPUT_MESSAGE);
		return SCANNER.nextLine();
	}

	public static int calculate(String[] formula) {
		int result = Integer.parseInt(formula[0]);

		for (int i = 1, len = formula.length; i < len; i += 2) {
			int value = Integer.parseInt(formula[i + 1]);
			result = Operator.findOperator(formula[i]).calculate(result, value);

		}

		return result;
	}

	public static void main(String[] args) {
		String[] b = "2 + 5 - 1".split(" ");

		System.out.println(calculate(b));
		int a = calculate(b);
	}
}