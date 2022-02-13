package racingcar.domain.car.condition;

import java.util.Collections;
import java.util.List;

public enum DuplicateName {

	MAXIMUM(1);

	private final int number;

	DuplicateName(int number) {
		this.number = number;
	}

	public static boolean isExcessiveDuplicated(List<String> names, String name) {
		return (Collections.frequency(names, name) > MAXIMUM.number);
	}

}
