package calculator;

public class StringCalculator {
	public static int splitAndSum(String a) {
		if (checkNull(a)) {
			return 0;
		}

	}

	private static boolean checkNull(String a) {
		return a == null || a.isEmpty();
	}

}
