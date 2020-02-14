package racingcar.domain;

public class Times {
	public static final int MINIMUM = 1;

	private int times;

	public Times(String times) throws Exception {
		int parsed = Integer.parseInt(times);
		if (parsed < MINIMUM) {
			throw new Exception("시도 횟수는 2번 이상이어야 합니다.\n");
		}
		this.times = parsed;
	}

	public void reduce() {
		times--;
	}

	public boolean isDone() {
		return times == 0;
	}
}
