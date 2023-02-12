package racingcar.domain.car;

import static racingcar.messsages.ExceptionMessage.*;

import java.util.Arrays;
import java.util.function.IntPredicate;

public enum Movement {
	MOVE_STOP(0, number -> 0 <= number && number <= 3),
	MOVE_FORWARD(1, number -> 4 <= number && number <= 9);

	private final int distance;
	private final IntPredicate range;

	Movement(int distance, IntPredicate range) {
		this.distance = distance;
		this.range = range;
	}

	public static Movement from(int number) {
		return Arrays.stream(Movement.values())
			.filter(movement -> movement.range.test(number))
			.findAny()
			.orElseThrow(() -> new IllegalArgumentException(MOVEMENT_NOT_FOUND_EXCEPTION.getMessage()));
	}

	public int getDistance() {
		return this.distance;
	}
}
