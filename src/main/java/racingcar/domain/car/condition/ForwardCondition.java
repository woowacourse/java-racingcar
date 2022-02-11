package racingcar.domain.car.condition;

public enum ForwardCondition {

	MINIMUM(4);

	private final int value;

	ForwardCondition(int value) {
		this.value = value;
	}

	public static boolean isInRange(int number) {
		return (number >= MINIMUM.value);
	}

}
