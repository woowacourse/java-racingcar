package calculator;

public class Calculator {
	public int sum(int[] nums) {
		int total = 0;

		checkNegative(nums);
		for (int num : nums) {
			total += num;
		}
		return total;
	}

	private void checkNegative(int[] nums) {
		for (int num : nums) {
			if (num < 0) {
				throw new RuntimeException("음수 불가능");
			}
		}
	}
}
