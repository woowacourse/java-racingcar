package racingcar.domain;

import java.util.Objects;

public class Round {

	private final int number;

	private Round(int number) {
		this.number = number;
	}

	public static Round of(int number) {
		return new Round(number);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Round round = (Round)o;
		return number == round.number;
	}

	@Override
	public int hashCode() {
		return Objects.hash(number);
	}
}
