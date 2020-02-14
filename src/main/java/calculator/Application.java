package calculator;

import calculator.domain.CalculatorController;

public class Application {
	public static void main(String[] args) {
		try {
			CalculatorController controller = new CalculatorController();
			System.out.println(controller.run());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
