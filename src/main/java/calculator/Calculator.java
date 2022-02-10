package calculator;

public class Calculator {
	public int sum(int[] nums) {
		int total = 0;

		for (int num : nums) {
			total += num;
		}
		return total;
	}
}
