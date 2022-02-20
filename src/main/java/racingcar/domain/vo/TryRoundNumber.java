package racingcar.domain.vo;

import static racingcar.validator.TryRoundNumberValidator.*;

import java.util.Objects;

public class TryRoundNumber {

	private final int tryRoundNumber;

	public TryRoundNumber(final String input) {
		validateNumber(input);
		this.tryRoundNumber = Integer.parseInt(input);
	}

	public int get() {
		return tryRoundNumber;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		TryRoundNumber that = (TryRoundNumber)o;
		return tryRoundNumber == that.tryRoundNumber;
	}

	@Override
	public int hashCode() {
		return Objects.hash(tryRoundNumber);
	}

	@Override
	public String toString() {
		return "TryRoundNumber{" +
			"tryRoundNumber=" + tryRoundNumber +
			'}';
	}
}
